package com.logicbig.example;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.util.function.Function;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MyPrototypeBean prototypeBean(String name) {
        return new MyPrototypeBean(name);
    }

    @Bean
    public Function<String, MyPrototypeBean> prototypeBeanFunction() {
        return name -> prototypeBean(name);
    }

    @Bean
    public MySingletonBean singletonBean() {
        return new MySingletonBean();
    }

    @Bean
    public BeanNameFormatter beanNameFormatterBean() {
        return new BeanNameFormatter();
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
