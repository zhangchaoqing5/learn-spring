package org.kira.annotation;

import org.springframework.stereotype.Component;

@Component
public class BeanA {
    public void say() {
        System.out.println("beanA");
    }

}
