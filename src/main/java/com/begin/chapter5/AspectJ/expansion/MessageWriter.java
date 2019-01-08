package com.begin.chapter5.AspectJ.expansion;

public class MessageWriter {

    public void writeMessage(){
        System.out.println("footbar");
    }

    public void foo(){
        System.out.println("foo");
    }
}
