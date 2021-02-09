package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IfUniqueWithConsumer {

    @Bean
    MsgBean msgBean() {
        return new MsgBean("test msg 1");
    }

    //if uncomment @Bean annotation here,then nothing will print
    @Bean
    MsgBean msgBean2() {
        return new MsgBean("test msg 2");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IfUniqueWithConsumer.class);
        ObjectProvider<MsgBean> beanProvider = context.getBeanProvider(MsgBean.class);
        beanProvider.ifUnique(msgBean -> msgBean.showMessage());
    }
}
