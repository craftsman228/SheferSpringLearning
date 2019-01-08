package com.begin.chapter5.AllTypesOfAdvices.Interceptor;

public class ErrorBean {

    public void errorPhoneMethod() throws Exception {
        throw new Exception("Foo");
    }

    public void otherErrorMethod(){
        throw new IllegalArgumentException("Bar");
    }
}
