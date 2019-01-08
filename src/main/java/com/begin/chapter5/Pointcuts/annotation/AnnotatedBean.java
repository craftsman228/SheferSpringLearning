package com.begin.chapter5.Pointcuts.annotation;

public class AnnotatedBean {

    @AdviceRequired
    public void foo1(int x){
        System.out.println("Invoked foo() with parameter: " + x);
    }

    public void bar(){
        System.out.println("bar");
    }
}
