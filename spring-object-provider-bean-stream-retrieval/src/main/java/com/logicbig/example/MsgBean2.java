package com.logicbig.example;

import org.springframework.core.Ordered;

public class MsgBean2 implements Ordered {

    private String msg;
    private int order;

    public MsgBean2(String msg, int order) {
        this.msg = msg;
        this.order = order;
    }

    public void showMessage() {
        System.out.println("msg: " + msg);
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "MsgBean2{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
