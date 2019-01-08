package com.begin.chapter5.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* foo*(int)) && args(numVal)")
    public void fooExecution(int numVal){}

    @Pointcut("bean(myDependency*)")
    public void inMyDependency(){}

    @Before("fooExecution(numVal) && inMyDependency()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, int numVal){
        if (numVal != 100) {
            System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " "
                    + joinPoint.getSignature().getName() + " argument: " + numVal);
        }
    }

    @Around("fooExecution(numVal) && inMyDependency()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, int numVal) throws Throwable {
        System.out.println("Before execution: " + joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName() + " argument: " + numVal);
        Object retVal = joinPoint.proceed();
        System.out.println("After execution: " + joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName() + " argument: " + numVal);
        return retVal;
    }
}
