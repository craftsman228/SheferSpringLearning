package com.begin.chapter5.FlexiblePointcuts.ComposablePointcut;

import com.begin.chapter5.FlexiblePointcuts.ControlFlow.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;
import java.lang.reflect.Method;

public class ComposablePointcutExample {

    public static void main(String[] args) {
        SimpleBean target = new SimpleBean();
        ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE, new GetterMethodМatcher());

        //Test1
        System.out.println("Test1");
        SimpleBean proxy = getProxy(pc, target);
        testInvoke(proxy);

        //Test2
        System.out.println("Test2");
        pc.union(new SetterMethodMatcher());
        proxy = getProxy(pc, target);
        testInvoke(proxy);

        //Test3
        System.out.println("Test3");
        pc.intersection(new AgeMethodMatcher());
        proxy = getProxy(pc, target);
        testInvoke(proxy);
    }

    private static class GetterMethodМatcher extends StaticMethodMatcher {
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return method.getName().startsWith("get");
        }
    }

    private static class SetterMethodMatcher extends StaticMethodMatcher{
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return method.getName().startsWith("set");
        }
    }

    private static class AgeMethodMatcher extends StaticMethodMatcher{
        @Override
        public boolean matches(Method method, Class<?> aClass) {
            return "getAge".equals(method.getName());
        }
    }

    private static SimpleBean getProxy(ComposablePointcut pointcut, SimpleBean target){
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());
        ProxyFactory px = new ProxyFactory();
        px.setTarget(target);
        px.addAdvisor(advisor);
        return (SimpleBean) px.getProxy();
    }

    private static void testInvoke(SimpleBean proxy){
        proxy.getName();
        proxy.getAge();
        proxy.setName("Ivan");
    }

}
