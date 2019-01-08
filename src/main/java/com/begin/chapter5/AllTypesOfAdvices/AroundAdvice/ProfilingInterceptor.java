package com.begin.chapter5.AllTypesOfAdvices.AroundAdvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(methodInvocation.getMethod().getName());
        Object value = methodInvocation.proceed();
        stopWatch.stop();
        dumpInfo(methodInvocation, stopWatch.getTotalTimeMillis());
        return value;
    }

    private void dumpInfo(MethodInvocation methodInvocation, long ms){
        Method m = methodInvocation.getMethod();
        Object target = methodInvocation.getThis();
        Object[] args = methodInvocation.getArguments();
        System.out.println("Method: " + m.getName());
        System.out.println("On object of type: " + target.getClass().getName());
        for (int i = 0; i < args.length; i++){
            System.out.println("Argument: " + args[i]);
        }
        System.out.println("\n");
        System.out.println("Took a second: " + ms + " ms");
    }
}
