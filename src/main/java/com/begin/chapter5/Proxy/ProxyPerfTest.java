package com.begin.chapter5.Proxy;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {

    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
        runCGlibTest(advisor, target);
        runFrozenCGlibTests(advisor, target);
        runJDKTests(advisor, target);
    }

    private static void runCGlibTest(Advisor advisor, SimpleBean target){
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        SimpleBean bean = (SimpleBean) pf.getProxy();
        System.out.println("running CGliB standart test");
        test(bean);
    }

    private static void runFrozenCGlibTests(Advisor advisor, SimpleBean target){
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.setFrozen(true);
        pf.addAdvisor(advisor);

        SimpleBean bean = (SimpleBean) pf.getProxy();
        System.out.println("running CGliB frozen test");
        test(bean);
    }

    private static void runJDKTests(Advisor advisor, SimpleBean target){
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(new Class[]{SimpleBean.class});

        SimpleBean bean = (SimpleBean) pf.getProxy();
        System.out.println("running JDK test");
        test(bean);
    }

    private static void test(SimpleBean bean){
        long before = 0;
        long after = 0;
        System.out.println("Testing advised method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++){
            bean.advice();
        }
        after = System.currentTimeMillis();
        System.out.println("Took a time: " + (after - before) + " ms");

        System.out.println("Testing unadvised method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++){
            bean.unadvice();
        }
        after = System.currentTimeMillis();
        System.out.println("Took a time: " + (after - before) + " ms");

        System.out.println("Testing hashCode method");
        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++){
            bean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took a time: " + (after - before) + " ms");

        Advised advised = (Advised) bean;

        System.out.println ( "Testing Advised. getProxyTargetClass () Method") ;

        before = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++){
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took a time: " + (after - before) + " ms");
        System.out.println(">>>\n");

    }
}
