package com.begin.chapter3.Autolink;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {

    private Foo foo;

    public Target() {
    }

    public Target(Foo foo) {
        this.foo = foo;
        System.out.println("Call foo variable " + this.foo);
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }

    public void setFoo2(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo2 set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("autolink-context.xml");
        context.refresh();

        Target t = null;
        System.out.println("Using byName \n");
        t = (Target) context.getBean("targetByName");

        System.out.println("Using byType \n");
        t = (Target) context.getBean("targetByType");

        System.out.println("Using constructor \n");
        t = (Target) context.getBean("targetByConstructor");
    }
}
