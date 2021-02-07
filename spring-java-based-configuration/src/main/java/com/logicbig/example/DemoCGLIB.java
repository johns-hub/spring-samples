package com.logicbig.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoCGLIB {

    private int counter;

    @Bean
    public String something() {
        System.out.println("method invoked");
        return String.valueOf(++counter);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoCGLIB.class);
        DemoCGLIB bean = context.getBean(DemoCGLIB.class);
        System.out.println(bean.something());
        System.out.println(bean.something());
    }
}
