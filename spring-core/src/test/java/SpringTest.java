import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * desc: TODO
 *
 * @author hz.lei
 * @since 2018年07月22日 下午3:56
 */
public class SpringTest {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:services.xml");
        applicationContext.registerShutdownHook();


        applicationContext.start();

        applicationContext.getBean("helloLifeCycle");
        applicationContext.stop();
        applicationContext.destroy();
        applicationContext.close();
        Thread.sleep(1000);

    }
}
