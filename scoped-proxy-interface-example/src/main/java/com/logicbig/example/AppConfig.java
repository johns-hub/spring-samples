package com.logicbig.example;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode = ScopedProxyMode.INTERFACES)
    public IPrototype prototypeBean() {
        return new MyPrototypeBean();
    }

    @Bean
    public MySingletonBean singletonBean() {
        return new MySingletonBean();
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MySingletonBean bean = context.getBean(MySingletonBean.class);
        bean.showMessage();
        Thread.sleep(1000);

        bean = context.getBean(MySingletonBean.class);
        bean.showMessage();
    }
}
