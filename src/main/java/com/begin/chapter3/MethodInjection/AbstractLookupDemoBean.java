package com.begin.chapter3.MethodInjection;

public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract MyHelper getMyHelper();

    public void someOperator() {
        getMyHelper().soSomething();
    }
}
