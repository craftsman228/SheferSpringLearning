package com.begin.chapter4.JavaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaRunner {

    public static void main(String[] args) {
         ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
         MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);
         renderer.render();
    }
}
