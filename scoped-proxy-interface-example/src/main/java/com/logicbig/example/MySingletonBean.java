package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;

public class MySingletonBean {

    @Autowired
    private IPrototype prototypeBean;

    public void showMessage() {
        System.out.println("Hi, the time is "+prototypeBean.getDateTime());
    }
}
