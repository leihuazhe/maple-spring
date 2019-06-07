package com.hzways.aop.customer;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("services9.xml");
        load(context);
    }

    private static void load(ApplicationContext ctx) throws Exception {
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            Object bean = ctx.getBean(name);
            //Obtain the original bean of the proxy object.
            Object target = getTarget(bean);

            for (Method method : target.getClass().getDeclaredMethods()) {
                boolean annotationPresent = method.isAnnotationPresent(ApiMapping.class);
//                System.out.println("beanName: " + name + ", method: " + method.getName() + ", isPresent: " + annotationPresent);

                if (annotationPresent) {
                    ApiMapping annotation = method.getAnnotation(ApiMapping.class);
                    System.out.println("Get custom annotation value: " + annotation.value());
                }
            }
        }
    }

    /**
     * Get original bean instance.
     */
    private static Object getTarget(Object proxy) throws Exception {
        if (!AopUtils.isAopProxy(proxy)) {
            return proxy;
        }

        if (AopUtils.isJdkDynamicProxy(proxy)) {
            return getJdkDynamicProxyTargetObject(proxy);
        } else {
            return getCglibProxyTargetObject(proxy);
        }
    }

    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);

        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        return ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
    }

    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);

        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);

        Object target = ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();

        return target;
    }

    //----------------------------------------------------------------------------------------------------------------

    public static void loadBack(ApplicationContext ctx) throws Exception {
        Object adviseObj = ctx.getBean("dataTransferService");
        DataTransferService service = ctx.getBean(DataTransferService.class);

        Method syncData = service.getClass().getMethod("syncData", String.class);

        Method method = checkProxy(syncData, service);

        boolean annotationPresent = method.isAnnotationPresent(ApiMapping.class);

        System.out.println(annotationPresent);
    }

    private static Method checkProxy(Method methodArg, Object bean) throws Exception {
        Method method = methodArg;
        if (AopUtils.isJdkDynamicProxy(bean)) {
            try {
                // Found a @KafkaListener method on the target class for this JDK proxy ->
                // is it also present on the proxy itself?
                method = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                Class<?>[] proxiedInterfaces = ((Advised) bean).getProxiedInterfaces();
                for (Class<?> iface : proxiedInterfaces) {
                    try {
                        method = iface.getMethod(method.getName(), method.getParameterTypes());
                        break;
                    } catch (NoSuchMethodException noMethod) {
                    }
                }
            } catch (SecurityException ex) {
                ReflectionUtils.handleReflectionException(ex);
            } catch (NoSuchMethodException ex) {
                throw new IllegalStateException(String.format(
                        "@KafkaListener method '%s' found on bean target class '%s', " +
                                "but not found in any interface(s) for bean JDK proxy. Either " +
                                "pull the method up to an interface or switch to subclass (CGLIB) " +
                                "proxies by setting proxy-target-class/proxyTargetClass " +
                                "attribute to 'true'", method.getName(), method.getDeclaringClass().getSimpleName()), ex);
            }
        } else {
            Object cglibProxyTargetObject = getCglibProxyTargetObject(bean);
            method = cglibProxyTargetObject.getClass().getMethod(method.getName(), method.getParameterTypes());
            return method;
        }
        return method;
    }
}
