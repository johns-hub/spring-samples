package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class MySingletonBean {

    @Autowired
    private Function<String, MyPrototypeBean> myPrototypeBeanFunction;

    public void showMessage() {
        MyPrototypeBean bean = myPrototypeBeanFunction.apply("Default Bean");
        System.out.printf("Time: %s from bean: %s - instance: %s%n", bean.getDateTime(), bean.getFormattedName(),
                System.identityHashCode(bean));
    }
}
