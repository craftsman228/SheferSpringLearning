package com.begin.chapter5.Pointcuts.name_matching;

import com.begin.chapter5.Pointcuts.static_type.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class NamePointcutExample {

    public static void main(String[] args) {
        NameBean target = new NameBean();
        NameMatchMethodPointcut namePointcut = new NameMatchMethodPointcut();
        namePointcut.addMethodName("foo");
        namePointcut.addMethodName("bar");
        Advisor advisor = new DefaultPointcutAdvisor(namePointcut, new SimpleAdvice());

        ProxyFactory px = new ProxyFactory();
        px.setTarget(target);
        px.addAdvisor(advisor);
        NameBean nameBean = (NameBean) px.getProxy();

        nameBean.foo();
        nameBean.foo(100);
        nameBean.bar();
        nameBean.yup();
    }
}
