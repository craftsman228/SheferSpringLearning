package com.begin.chapter5.Pointcuts.dynamic_type;

import com.begin.chapter5.Pointcuts.static_type.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutExample {

    public static void main(String[] args) {
        SimpleBean target = new SimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(), new SimpleAdvice());
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();

        proxy.foo(100);
        proxy.foo(1000);
        proxy.foo(10000);

        proxy.bar();
        proxy.bar();
        proxy.bar();

    }
}
