package com.logicbig.example;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/object-provider-with-function-callbacks.html
 */
@Configuration
public class GetIfAvailableWithSupplier {

    //uncomment @Bean then getIfAvailable will return this instance
    //@Bean
    MsgBean msgBean() {
        return new MsgBean("test msg");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(GetIfAvailableWithSupplier.class);
        ObjectProvider<MsgBean> beanProvider = context.getBeanProvider(MsgBean.class);
        MsgBean exampleBean = beanProvider.getIfAvailable(() -> new MsgBean("default msg"));
        exampleBean.showMessage();
    }
}
