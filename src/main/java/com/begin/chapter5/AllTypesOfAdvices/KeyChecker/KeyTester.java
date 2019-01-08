package com.begin.chapter5.AllTypesOfAdvices.KeyChecker;

import org.springframework.aop.framework.ProxyFactory;

public class KeyTester {

    private static KeyGenerator keyGenerator(){
        KeyGenerator target = new KeyGenerator();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new WeakKeyChecker());
        return (KeyGenerator) proxyFactory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator generator = keyGenerator();
        for(int i = 0; i < 10; i++){
            try {
                long key = generator.getKey();
                System.out.println("The key " + key);
            }catch (SecurityException ex){
                ex.getStackTrace();
            }
        }
    }
}
