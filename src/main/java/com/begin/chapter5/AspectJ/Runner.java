package com.begin.chapter5.AspectJ;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("/aop/aspectj-config.xml");
        context.refresh();

        MyBean myBean = (MyBean) context.getBean("myBean");
        myBean.execute();
    }
}
