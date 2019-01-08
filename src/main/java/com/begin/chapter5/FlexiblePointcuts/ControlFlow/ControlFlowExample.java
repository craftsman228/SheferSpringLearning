package com.begin.chapter5.FlexiblePointcuts.ControlFlow;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowExample {

    public static void main(String[] args) {
        ControlFlowExample example = new ControlFlowExample();
        example.run();
    }

    public void run(){
        TestBean target = new TestBean();
        Pointcut pointcut = new ControlFlowPointcut(ControlFlowExample.class, "test");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        TestBean bean = (TestBean) pf.getProxy();

        System.out.println("Trying normal invoke");
        bean.foo();

        System.out.println("Trying by using ControlFlowPoincut");
        test(bean);
    }

    private void test(TestBean bean){
        bean.foo();
    }
}
