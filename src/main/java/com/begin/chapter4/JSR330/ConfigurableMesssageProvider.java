package com.begin.chapter4.JSR330;

import javax.inject.Inject;
import javax.inject.Named;

@Named("messageProvider")
public class ConfigurableMesssageProvider implements MessageProvider {

    private String message = "Default message";

    public ConfigurableMesssageProvider() {
    }

    @Inject
    @Named("message")
    public ConfigurableMesssageProvider(String message) {
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
