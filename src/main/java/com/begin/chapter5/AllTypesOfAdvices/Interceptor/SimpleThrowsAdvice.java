package com.begin.chapter5.AllTypesOfAdvices.Interceptor;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {

    public static void main(String[] args) {
        ErrorBean target = new ErrorBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new SimpleThrowsAdvice());
        ErrorBean errorBean = (ErrorBean) proxyFactory.getProxy();
        try{
            errorBean.errorPhoneMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            errorBean.otherErrorMethod();
        }catch (Exception e){}
    }

    public void afterThrowing(Exception ex){
        System.out.println("***");
        System.out.println("Exception generic capture ");
        System.out.println("Exception with name: " + ex.getClass().getName());
        System.out.println("\n");
    }

    public void afterThrowing(Method method, Object obj, Object[] objects, IllegalArgumentException ex){
        System.out.println("***");
        System.out.println("Exception generic capture ");
        System.out.println("Exception with name: " + ex.getClass().getName());
        System.out.println("Method name " + method.getName());
        System.out.println("\n");
    }
}
