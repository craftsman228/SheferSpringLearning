package com.begin.chapter5.Pointcuts.aspectJ;

public class AspectBean {

    public void foo1(){
        System.out.println("Invoked foo2()");
    }

    public void foo2(){
        System.out.println("Invoked foo2()");
    }

    public void bar(){
        System.out.println("bar");
    }
}
