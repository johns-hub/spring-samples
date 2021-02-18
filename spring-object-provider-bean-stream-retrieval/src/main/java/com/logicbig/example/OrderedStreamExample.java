package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class OrderedStreamExample {

    @Bean
    @Order(2)
    MsgBean msgBean() {
        return new MsgBean("test msg 1");
    }

    @Bean
    @Order(1)
    MsgBean msgBean2() {
        return new MsgBean("test msg 2");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(OrderedStreamExample.class);
        ObjectProvider<MsgBean> beanProvider = context.getBeanProvider(MsgBean.class);
        System.out.println("-- default order --");
        beanProvider.stream().forEach(System.out::println);
        System.out.println("-- ordered by @Order --");
        beanProvider.orderedStream().forEach(System.out::println);
    }
}
