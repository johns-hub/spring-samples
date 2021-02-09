package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetIfUniqueWithSupplier {

    @Bean
    MsgBean msgBean() {
        return new MsgBean("test msg 1");
    }

    //uncomment @Bean here,then 'test msg 1' will print
    @Bean
    MsgBean msgBean2() {
        return new MsgBean("test msg 2");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(GetIfUniqueWithSupplier.class);
        ObjectProvider<MsgBean> beanProvider = context.getBeanProvider(MsgBean.class);
        MsgBean exampleBean = beanProvider.getIfUnique(() -> new MsgBean("default msg"));
        exampleBean.showMessage();
    }
}
