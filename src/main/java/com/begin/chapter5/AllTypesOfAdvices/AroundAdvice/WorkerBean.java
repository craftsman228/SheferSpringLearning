package com.begin.chapter5.AllTypesOfAdvices.AroundAdvice;

public class WorkerBean {


    public void doSomeWork(int nanoTime){
        for (int i = 0; i < nanoTime; i++){
            work();
        }
    }

    public void work(){
        System.out.println("");
    }
}
