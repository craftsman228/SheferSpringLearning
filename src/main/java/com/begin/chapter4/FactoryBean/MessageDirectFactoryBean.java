package com.begin.chapter4.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class MessageDirectFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

    private String algoName = "MD5";
    private MessageDigest messageDigest = null;

    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<?> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algoName);
    }

    public void setAlgoName(String algoName) {
        this.algoName = algoName;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("message-digest-factory.xml");
        context.refresh();

        MessageDagester digester = (MessageDagester) context.getBean("digester");
        digester.digest("asssss");
    }
}
