package com.begin.chapter5.HelloWorld;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPRunning {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageDecorator());
        proxyFactory.setTarget(target);

        MessageWriter proxy = (MessageWriter) proxyFactory.getProxy();
        target.writeMsg();
        System.out.println("");
        proxy.writeMsg();
    }
}
