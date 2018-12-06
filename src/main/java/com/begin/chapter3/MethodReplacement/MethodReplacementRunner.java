package com.begin.chapter3.MethodReplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementRunner {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("method-replacement.xml");
        context.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) context.getBean("replacementTarget");
        ReplacementTarget standartReplacementTarget = (ReplacementTarget) context.getBean("standartTarget");

        displayInfo(replacementTarget);
        displayInfo(standartReplacementTarget);
    }

    public static void displayInfo(ReplacementTarget target){
        System.out.println(target.formatMessage("New method replacement"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("testStart");
        for (int i = 0; i < 1000; i++){
            String out = target.formatMessage("process running");
        }
        stopWatch.stop();
        System.out.println("1000 invocations was " + stopWatch.getTotalTimeMillis() + "ms");
    }
}
