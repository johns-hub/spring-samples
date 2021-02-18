package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderedStreamExample2 {

    @Bean
    MsgBean2 msgBean() {
        return new MsgBean2("test msg 1", 2);
    }

    @Bean
    MsgBean2 msgBean2() {
        return new MsgBean2("test msg 2", 1);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(OrderedStreamExample2.class);
        ObjectProvider<MsgBean2> beanProvider = context.getBeanProvider(MsgBean2.class);
        System.out.println("-- default order --");
        beanProvider.stream().forEach(System.out::println);
        System.out.println("-- ordered by Ordered interface --");
        beanProvider.orderedStream().forEach(System.out::println);
    }
}
