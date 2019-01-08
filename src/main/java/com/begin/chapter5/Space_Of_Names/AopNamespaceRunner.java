package com.begin.chapter5.Space_Of_Names;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("/aop/namespace.xml");
        context.refresh();

        MyBean myBean = (MyBean) context.getBean("myBean");
        myBean.execute();
    }
}
