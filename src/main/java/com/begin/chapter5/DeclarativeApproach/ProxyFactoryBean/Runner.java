package com.begin.chapter5.DeclarativeApproach.ProxyFactoryBean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("aop/app-context.xml");
        context.refresh();

        MyBean bean1 = (MyBean) context.getBean("myBean1");
        MyBean bean2 = (MyBean) context.getBean("myBean2");

        System.out.println("Bean1 execution: ");
        bean1.execute();

        System.out.println("Bean2 execution: ");
        bean2.execute();
    }
}
