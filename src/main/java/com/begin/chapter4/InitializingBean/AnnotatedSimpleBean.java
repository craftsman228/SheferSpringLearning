package com.begin.chapter4.InitializingBean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class AnnotatedSimpleBean {

    private static final String DEFAULT_NAME = "Monster Ponster";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("annotated-simple-bean.xml");
        context.refresh();

        AnnotatedSimpleBean annotatedBeanA = (AnnotatedSimpleBean) context.getBean("annotatedBeanA", context);
        AnnotatedSimpleBean annotatedBeanB = (AnnotatedSimpleBean) context.getBean("annotatedBeanB", context);
     //   AnnotatedSimpleBean annotatedBeanC = (AnnotatedSimpleBean) context.getBean("annotatedBeanC", context);
    }

    @Override
    public String toString() {
        return "AnnotatedSimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("Initializing bean");
        if (name == null){
            System.out.println("Using default method");
            name = DEFAULT_NAME;
        }if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("Incorrect bean property " + AnnotatedSimpleBean.class);
        }
    }

    public AnnotatedSimpleBean getBean(String name, ApplicationContext context) {
        try {
            AnnotatedSimpleBean simpleBean = (AnnotatedSimpleBean) context.getBean(name);
            System.out.println(simpleBean);
            return simpleBean;
        } catch (BeanCreationException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }
}
