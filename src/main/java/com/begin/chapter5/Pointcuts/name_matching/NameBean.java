package com.begin.chapter5.Pointcuts.name_matching;

public class NameBean {

    public void foo(){
        System.out.println("foo");
    }

    public void foo(int x){
        System.out.println("Invoked foo() with x");
    }

    public void bar(){
        System.out.println("bar");
    }

    public void yup(){
        System.out.println("yup");
    }
}
