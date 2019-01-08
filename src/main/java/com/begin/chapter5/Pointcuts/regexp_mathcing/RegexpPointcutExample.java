package com.begin.chapter5.Pointcuts.regexp_mathcing;

import com.begin.chapter5.Pointcuts.static_type.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class RegexpPointcutExample {

    public static void main(String[] args) {
        RegexBean target = new RegexBean();
        JdkRegexpMethodPointcut regex = new JdkRegexpMethodPointcut();
        regex.setPattern(".*foo.*");
        Advisor advisor = new DefaultPointcutAdvisor(regex, new SimpleAdvice());

        ProxyFactory px = new ProxyFactory();
        px.setTarget(target);
        px.addAdvisor(advisor);
        RegexBean regexBean = (RegexBean) px.getProxy();

        regexBean.foo1();
        regexBean.foo2();
        regexBean.bar();
    }
}
