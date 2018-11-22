package com.begin;

public class DecoupledHelloWorld {

    public static void main(String[] args) {
        MessageProvider messageProvider = new HelloWorldInitializtion();
        MessageRenderer messageRenderer = new StandartRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
