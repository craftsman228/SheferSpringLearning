package com.begin.chapter5.AllTypesOfAdvices.AroundAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingRunner {

    public static void main(String[] args) {
        WorkerBean workerBean = getWorkerBean();
        workerBean.doSomeWork(10000);
    }

    public static WorkerBean getWorkerBean(){
        WorkerBean target =  new WorkerBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new ProfilingInterceptor());
        return (WorkerBean) proxyFactory.getProxy();
    }
}
