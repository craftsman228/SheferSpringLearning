package com.begin.chapter3.MethodReplacement;

public class ReplacementTarget {

    public String formatMessage(String text){
        return "<h1>" + text + "</h1>";
    }

    public String formatMessage(Object text){
        return "<h1>" + text + "</h1>";
    }
}
