package com.begin.chapter3.ConstructorInjection;

import com.begin.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
