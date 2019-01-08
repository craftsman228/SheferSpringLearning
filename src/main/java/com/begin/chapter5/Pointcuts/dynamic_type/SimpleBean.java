package com.begin.chapter5.Pointcuts.dynamic_type;

public class SimpleBean {

    public void foo(int x){
        System.out.println("Invoked foo() with " + x);
    }

    public void bar(){
        System.out.println("Invoked bar()");
    }
}
