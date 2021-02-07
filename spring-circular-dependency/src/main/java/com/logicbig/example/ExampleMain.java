package com.logicbig.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@ComponentScan(basePackageClasses = ExampleMain.class, useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = {ExampleMain.BeanA.class, ExampleMain.BeanB.class})})
@Configuration
public class ExampleMain {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ExampleMain.class);
    }

    @Component
    public static class BeanA {
        private final BeanB beanB;
        public BeanA(BeanB beanB) {
            this.beanB = beanB;
        }
    }

    @Component
    public static class BeanB {
        private final BeanA beanA;
        public BeanB(BeanA beanA) {
            this.beanA = beanA;
        }
    }
}
