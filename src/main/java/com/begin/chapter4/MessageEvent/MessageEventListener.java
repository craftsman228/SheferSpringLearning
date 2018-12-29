package com.begin.chapter4.MessageEvent;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent event = messageEvent;
        System.out.println("Recieved: " + event.getMessage());
    }
}
