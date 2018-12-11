package com.begin.chapter2;

public interface MessageRenderer {


    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
