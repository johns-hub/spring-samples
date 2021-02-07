package com.logicbig.example.service.impl;

import com.logicbig.example.service.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public void sayHi(String message) {
        System.out.println(message);
    }
}
