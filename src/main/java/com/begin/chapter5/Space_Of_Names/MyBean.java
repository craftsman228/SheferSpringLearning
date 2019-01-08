package com.begin.chapter5.Space_Of_Names;

public class MyBean {

    private MyDependency myDependency;

    public void execute(){
        myDependency.foo(101);
        myDependency.foo(100);
        myDependency.bar();
    }

    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}
