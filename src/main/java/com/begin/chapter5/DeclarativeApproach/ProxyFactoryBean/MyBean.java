package com.begin.chapter5.DeclarativeApproach.ProxyFactoryBean;

public class MyBean {

    private MyDependency myDependency;

    public void execute(){
        myDependency.bar();
        myDependency.foo();
    }

    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}
