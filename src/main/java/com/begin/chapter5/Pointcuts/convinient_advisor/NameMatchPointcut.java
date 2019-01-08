package com.begin.chapter5.Pointcuts.convinient_advisor;

import com.begin.chapter5.Pointcuts.name_matching.NameBean;
import com.begin.chapter5.Pointcuts.static_type.SimpleAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NameMatchPointcut {
    public static void main(String[] args) {
        NameBean target = new NameBean();
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.addMethodName("foo");
       // advisor.addMethodName("bar");

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        NameBean bean = (NameBean) pf.getProxy();
        bean.foo();
        bean.foo(100);
        bean.bar();
        bean.yup();
    }
}
