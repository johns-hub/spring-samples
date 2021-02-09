package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IfAvailableWithConsumer {

    //remove @Bean annotation then getIfAvailable  will print nothing
    @Bean
    MsgBean msgBean() {
        return new MsgBean("test msg");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IfAvailableWithConsumer.class);
        ObjectProvider<MsgBean> beanProvider = context.getBeanProvider(MsgBean.class);
        beanProvider.ifAvailable(msgBean -> msgBean.showMessage());
    }
}
