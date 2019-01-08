package com.begin.chapter5.DeclarativeApproach.ProxyFactoryBean;

import com.begin.chapter5.Introductions.IsModified;
import com.begin.chapter5.Introductions.TargetBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class IntroRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("aop/proxy-for-introduction.xml");
        context.refresh();

        TargetBean bean = (TargetBean) context.getBean("bean");
        IsModified isModified = (IsModified) bean;

        System.out.println("Is target bean: " + (bean instanceof TargetBean));
        System.out.println("Is IsModified " + (bean instanceof IsModified));

        System.out.println("Has been modified: " + isModified.isModified());

        bean.setName("PuppyX");
        System.out.println("Has been modified: " + isModified.isModified());

    }
}
