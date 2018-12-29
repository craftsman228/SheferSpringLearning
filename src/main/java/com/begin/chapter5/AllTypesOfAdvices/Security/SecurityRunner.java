package com.begin.chapter5.AllTypesOfAdvices.Security;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityRunner {

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SecureBean secureBean = getSecureBean();
        securityManager.login("chris", "pwd");
        secureBean.writeSecureMessage();
        securityManager.logout();
        try{
            securityManager.login("individualiser", "yyy");
            secureBean.writeSecureMessage();
        }catch (SecurityException ex){
            System.out.println("Exception caught " + ex.getMessage());
        }finally {
            securityManager.logout();
        }

        try{
            secureBean.writeSecureMessage();
        }catch (SecurityException ex){
            System.out.println("Exception caught " + ex.getMessage());
        }
    }

    private static SecureBean getSecureBean(){
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);
        SecureBean secureBean = (SecureBean) proxyFactory.getProxy();
        return secureBean;
    }
}
