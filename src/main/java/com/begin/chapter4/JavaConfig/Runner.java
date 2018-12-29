package com.begin.chapter4.JavaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("pre-java-conf.xml");
        MessageRenderer renderer = (MessageRenderer) context.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
