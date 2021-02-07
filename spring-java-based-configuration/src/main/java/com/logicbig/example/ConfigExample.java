package com.logicbig.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigExample {

    private int counter;

    @Bean
    public Greeter greeterBean() {
        return new Greeter();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigExample.class);
        Greeter greeter = context.getBean(Greeter.class);
        greeter.sayHi("Joe");
    }

    public static class Greeter {
        public void sayHi(String name) {
            System.out.println("Hi there, " + name);
        }
    }
}
