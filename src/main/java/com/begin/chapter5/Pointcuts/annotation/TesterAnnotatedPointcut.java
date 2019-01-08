package com.begin.chapter5.Pointcuts.annotation;

import com.begin.chapter5.Pointcuts.static_type.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class TesterAnnotatedPointcut {

    public static void main(String[] args) {
        AnnotatedBean target = new AnnotatedBean();
        AnnotationMatchingPointcut pc =
                AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory px = new ProxyFactory();
        px.setTarget(target);
        px.addAdvisor(advisor);
        AnnotatedBean annotatedBean = (AnnotatedBean) px.getProxy();

        annotatedBean.bar();
        annotatedBean.foo1(100);
    }
}
