package org.kira.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@ComponentScan("org.kira.annotation")
@Service("beanName")
public class AnnotationApplication {

}
