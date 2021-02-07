package com.logicbig.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;


@ComponentScan(basePackageClasses = ExampleMainFix2.class, useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = {ExampleMainFix2.BeanA.class, ExampleMainFix2.BeanB.class})})
@Configuration
public class ExampleMainFix2 {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ExampleMainFix2.class);
        BeanA beanA = context.getBean(BeanA.class);
        beanA.doSomething();
    }

    @Component
    static class BeanA {
        private final BeanB beanB;
        public BeanA(@Lazy BeanB b) {
            this.beanB = b;
        }

        public void doSomething() {
            System.out.println("do something");
        }
    }

    @Component
    static class BeanB {
        private final BeanA beanA;
        public BeanB(BeanA beanA) {
            this.beanA = beanA;
        }

        public void doSomething() {
            System.out.println("do something");
        }
    }
}
