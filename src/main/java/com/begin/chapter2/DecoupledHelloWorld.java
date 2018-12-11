package com.begin.chapter2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DecoupledHelloWorld {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("configurable-message-bean.xml");
        context.refresh();
        MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
    }
}
