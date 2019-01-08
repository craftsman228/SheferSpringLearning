package com.begin.chapter5.AllTypesOfAdvices;

import com.begin.chapter5.HelloWorld.MessageWriter;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class AfterReturningAdviceImpl implements AfterReturningAdvice {

    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AfterReturningAdviceImpl());
        proxyFactory.setTarget(target);

        MessageWriter writer = (MessageWriter) proxyFactory.getProxy();
        writer.writeMsg();
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("");
        System.out.println("After method " + method.getName());
    }
}
