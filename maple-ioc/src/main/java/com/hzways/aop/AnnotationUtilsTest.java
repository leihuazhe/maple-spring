package com.hzways.aop;

import com.hzways.aop.ann.ClassAnn;
import com.hzways.aop.ann.Maple;
import com.hzways.aop.ann.Maples;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import java.util.Arrays;
import java.util.Set;

/**
 * @author maple 2018.09.25 上午11:14
 */
public class AnnotationUtilsTest {

    @Test
    public void test1() {

        Set<Maple> test = AnnotationUtils.getRepeatableAnnotations(ClassUtils.getMethod(ClassAnn.class, "test"), Maple.class, Maples.class);


        test.forEach(a -> System.out.println(a.value()));

    }
}
