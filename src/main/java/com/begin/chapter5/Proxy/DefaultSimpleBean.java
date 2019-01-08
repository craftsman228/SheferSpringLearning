package com.begin.chapter5.Proxy;

public class DefaultSimpleBean implements SimpleBean{

    private long dummy = 0;


    @Override
    public void advice() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvice() {
        dummy = System.currentTimeMillis();
    }
}
