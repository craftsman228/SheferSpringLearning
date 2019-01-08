package com.begin.chapter5.DeclarativeApproach.ProxyFactoryBean;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Method executed: " + method.getName());
    }
}
