package org.kira;

import org.kira.annotation.AnnotationApplication;
import org.kira.annotation.BeanA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnnotationApplication.class);
        BeanA bean = annotationConfigApplicationContext.getBean(BeanA.class);
        bean.say();
    }

}
