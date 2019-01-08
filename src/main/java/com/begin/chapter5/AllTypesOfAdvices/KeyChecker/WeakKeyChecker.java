package com.begin.chapter5.AllTypesOfAdvices.KeyChecker;

import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

public class WeakKeyChecker implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if (o1 instanceof KeyGenerator && "getKey".equals(method.getName())){
            long key = ((Long) o) .longValue();
            if (key == KeyGenerator.WEAK_KEY){
                throw new SecurityException("Weak key, change it ASAP");
            }
        }
    }
}
