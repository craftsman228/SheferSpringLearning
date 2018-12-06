package com.begin.chapter3.RefInject;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProInjector {

    private BookwormOracle oracle;

    public void setOracle(BookwormOracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("ref-injector.xml");
        context.refresh();
        ProInjector injector = (ProInjector) context.getBean("proInjector");
        System.out.println(injector);
    }

    @Override
    public String toString() {
        return oracle.defineMeainingOfLife();
    }
}
