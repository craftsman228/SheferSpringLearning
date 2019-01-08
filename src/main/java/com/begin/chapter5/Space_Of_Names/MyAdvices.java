package com.begin.chapter5.Space_Of_Names;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvices {

    public void simpleBeforeAdvice(JoinPoint joinPoint, int numVal){

        if (numVal != 100) {
            System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " "
                    + joinPoint.getSignature().getName() + " argument: " + numVal);
        }
    }

    public Object aroundAdvice(ProceedingJoinPoint joinPoint, int numVal) throws Throwable {
        System.out.println("Before execution: " + joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName() + " argument: " + numVal);
        Object retVal = joinPoint.proceed();
        System.out.println("After execution: " + joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName() + " argument: " + numVal);
        return retVal;
    }
}
