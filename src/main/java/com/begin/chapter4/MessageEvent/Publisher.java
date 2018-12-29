package com.begin.chapter4.MessageEvent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publish(String event){
        applicationContext.publishEvent(new MessageEvent(this, event));
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("event-process.xml");
        Publisher publisher = (Publisher) context.getBean("publisher");
        publisher.publish("Hello guys");
        publisher.publish("Dangerous");
    }
}
