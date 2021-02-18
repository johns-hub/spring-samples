package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IteratorExample2 {

    @Bean
    MsgBean msgBean() {
        return new MsgBean("test msg 1");
    }

    @Bean
    MsgBean msgBean2() {
        return new MsgBean("test msg 2");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IteratorExample2.class);
        ObjectProvider<MsgBean> beanProvider = context.getBeanProvider(MsgBean.class);
        beanProvider.iterator().forEachRemaining(System.out::println);
    }
}
