package com.begin.chapter3.HierarchialApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierachialContext {

    public static void main(String[] args) {
        GenericXmlApplicationContext contextParent = new GenericXmlApplicationContext();
        contextParent.load("parent.xml");
        contextParent.refresh();

        GenericXmlApplicationContext contextChild = new GenericXmlApplicationContext();
        contextChild.load("child.xml");
        contextChild.setParent(contextParent);
        contextChild.refresh();

        SimpleTarget target1 = (SimpleTarget) contextChild.getBean("target1");
        SimpleTarget target2 = (SimpleTarget) contextChild.getBean("target2");
        SimpleTarget target3 = (SimpleTarget) contextChild.getBean("target3");

        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());


    }
}
