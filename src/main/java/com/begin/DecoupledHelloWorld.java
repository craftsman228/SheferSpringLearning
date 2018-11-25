package com.begin;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DecoupledHelloWorld {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("app-context.xml");
        context.refresh();
        MessageProvider messageProvider = context.getBean("provider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
    }
}
