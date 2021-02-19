package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MyPrototypeBean {

    @Autowired
    private BeanNameFormatter beanNameFormatter;
    private String dateTimeString = LocalDateTime.now().toString();
    private String name;

    public MyPrototypeBean(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTimeString;
    }

    public String getFormattedName() {
        return beanNameFormatter.formatName(name);
    }
}
