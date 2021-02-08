package com.logicbig.example;

import org.springframework.context.annotation.Bean;

public interface IMyConfig {
    @Bean
    default MyBean myBean() {
        return new MyBean();
    }
}
