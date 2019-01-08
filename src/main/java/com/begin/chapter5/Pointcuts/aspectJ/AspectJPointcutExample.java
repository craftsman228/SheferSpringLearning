package com.begin.chapter5.Pointcuts.aspectJ;

import com.begin.chapter5.Pointcuts.static_type.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectJPointcutExample {

    public static void main(String[] args) {
        AspectBean target = new AspectBean();
        AspectJExpressionPointcut expressionPointcut = new AspectJExpressionPointcut();
        expressionPointcut.setExpression("execution(* foo*( .. ))");
        Advisor advisor = new DefaultPointcutAdvisor(expressionPointcut, new SimpleAdvice());

        ProxyFactory px = new ProxyFactory();
        px.setTarget(target);
        px.addAdvisor(advisor);
        AspectBean aspectBean = (AspectBean) px.getProxy();
        aspectBean.bar();
        aspectBean.foo1();
        aspectBean.foo2();
    }
}
