package com.begin.chapter3.MethodInjection;

public class StandartLookupDemoBean implements DemoBean {

    private MyHelper myHelper;

    public MyHelper getMyHelper() {
        return this.myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    public void someOperator() {
        myHelper.soSomething();
    }
}
