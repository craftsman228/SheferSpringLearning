package com.begin.chapter4.BeanAware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanPrinter implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void executeOperation(){
      System.out.println( "Bean [" + beanName + "] - someOperation () ");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("bean-printer.xml");
        context.refresh();

        BeanPrinter beanPrinter = (BeanPrinter) context.getBean("beanPrintezz");
        beanPrinter.executeOperation();
    }
}
