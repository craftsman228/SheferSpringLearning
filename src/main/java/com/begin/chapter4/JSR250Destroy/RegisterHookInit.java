package com.begin.chapter4.JSR250Destroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RegisterHookInit implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof GenericXmlApplicationContext){
            ((GenericXmlApplicationContext) applicationContext).registerShutdownHook();
        }
    }
}
