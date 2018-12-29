package com.begin.chapter4.JavaConfig;

import com.begin.chapter2.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {

    private String message  = "Default message";

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
