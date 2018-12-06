package com.begin.chapter3.MethodInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("method-injection.xml");
        context.refresh();

        DemoBean abstractBean = (DemoBean) context.getBean("abstractBean");
        DemoBean standartBean = (DemoBean) context.getBean("standartLookupBean");

        displayInfo(abstractBean);
        displayInfo(standartBean);
    }


    public static void displayInfo(DemoBean demoBean){
        MyHelper helper1 = demoBean.getMyHelper();
        MyHelper helper2 = demoBean.getMyHelper();

        System.out.println("Help instances are the same: " + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int i = 0; i < 100000; i++){
            MyHelper helper = demoBean.getMyHelper();
            helper.soSomething();
        }
        stopWatch.stop();

        System.out.println("10000 got a time " + stopWatch.getTotalTimeMillis());
    }
}
