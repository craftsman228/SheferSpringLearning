package com.begin.chapter4.JSR330;

public interface MessageRenderer {


    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
