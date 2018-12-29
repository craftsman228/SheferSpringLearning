package com.begin.chapter5.AllTypesOfAdvices.Security;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedUser();

        if (user == null){
            System.out.println("No user identified");
            throw new SecurityException("You must invoke other method" + method.getName());
        }else if ("chris".equals(user.getUserName())){
            System.out.println("Such user is valid " + user.getUserName());
        }else {
            System.out.println("User is invalid");
            System.out.println("This is the user " + user.getUserName());
        }
    }
}
