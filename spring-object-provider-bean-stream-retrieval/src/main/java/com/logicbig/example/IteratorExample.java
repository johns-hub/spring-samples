package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java 8 Stream support in ObjectProvider to retrieve beans stream
 *
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/object-provider-bean-stream-retrieval.html
 */
@Configuration
public class IteratorExample {

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
                new AnnotationConfigApplicationContext(IteratorExample.class);
        ObjectProvider<MsgBean> beanProvider = context.getBeanProvider(MsgBean.class);
        beanProvider.forEach(System.out::println);
    }
}
