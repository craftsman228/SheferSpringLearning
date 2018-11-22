package com.begin;

import java.io.FileInputStream;
import java.util.Properties;

public class MessageSupportFactory {

    private static MessageSupportFactory instance;
    private Properties properties;
    private MessageRenderer messageRenderer;
    private MessageProvider messageProvider;

    private MessageSupportFactory(){
        properties = new Properties();
        try{
            properties.load(new FileInputStream("com/begin/msf.properties"));
            String rendererClass = properties.getProperty("renderer.class");
            String providedClass = properties.getProperty("provided.class");

            messageRenderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(providedClass).newInstance();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageRenderer getMessageRenderer(){
        return messageRenderer;
    }

    public MessageProvider getMessageProvider(){
        return messageProvider;
    }
}
