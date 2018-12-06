package com.begin.chapter4.LifecycleBean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {

    private static final String DEFAULT_NAME = "Luck Skywacker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init(){
        System.out.println("Init method");
        if (name == null){
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("Bad value " + SimpleBean.class);
        }
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("back-invoke-init.xml");
        context.refresh();

        SimpleBean simpleBean1 = (SimpleBean) context.getBean("simpleBean1", context);
    //    SimpleBean simpleBean2 = (SimpleBean) context.getBean("simpleBean2", context);
        SimpleBean simpleBean3 = (SimpleBean) context.getBean("simpleBean3", context);

    }

    private static SimpleBean getBean(String beanName, ApplicationContext context){
        try{
            SimpleBean bean = (SimpleBean) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        }catch (BeanCreationException ех){
            System.out.println("Bad value");
       }
        return null;
    }
}
