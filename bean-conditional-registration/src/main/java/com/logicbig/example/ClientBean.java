package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean {
    @Autowired
    private MyService myService;

    public MyService getMyService() {
        return myService;
    }
}
