package com.begin;

public interface MessageRenderer {


    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
