package com.begin.chapter5.Introductions;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

public class IntroductionRunner {

    public static void main(String[] args) {

        TargetBean target = new TargetBean();
        target.setName("Puppy");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        TargetBean targetBean = (TargetBean) pf.getProxy();
        IsModified proxyInterface = (IsModified) targetBean;

        System.out.println("Is target bean: " + (targetBean instanceof TargetBean));
        System.out.println("Is IsModified " + (targetBean instanceof IsModified));

        System.out.println("Has been modified: " + proxyInterface.isModified());

        targetBean.setName("PuppyX");
        System.out.println("Has been modified: " + proxyInterface.isModified());


    }
}
