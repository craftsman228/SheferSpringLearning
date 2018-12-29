package com.begin.chapter4.GroovyConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyBeansFromJava {

    public static void main(String[] args) {
        ApplicationContext context = new GenericGroovyApplicationContext("beans.groovy");
        Contact contact = context.getBean("contact", Contact.class);
        System.out.println(contact);
    }
}
