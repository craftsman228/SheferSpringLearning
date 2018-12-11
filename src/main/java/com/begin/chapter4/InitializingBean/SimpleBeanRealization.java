package com.begin.chapter4.InitializingBean;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanRealization implements InitializingBean {

    private static final String DEFAULT_NAME = "Monster Ponster";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void myInit(){
        System.out.println("My Init");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("initializing-bean.xml");
        context.refresh();

        SimpleBeanRealization simpleBeanRealizationX = (SimpleBeanRealization) context.getBean("simpleBeanX", context);
        SimpleBeanRealization simpleBeanRealizationY = (SimpleBeanRealization) context.getBean("simpleBeanY", context);
      //  SimpleBeanRealization simpleBeanRealizationZ = (SimpleBeanRealization) context.getBean("simpleBeanZ", context);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
        if (name == null){
            System.out.println("Using default method");
            name = DEFAULT_NAME;
        }if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("Incorrect bean property " + SimpleBeanRealization.class);
        }
    }

    @Override
    public String toString() {
        return "SimpleBeanRealization{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private static SimpleBeanRealization getBean(String beanName, ApplicationContext context){
        try{
            SimpleBeanRealization bean = (SimpleBeanRealization) context.getBean(beanName);
            System.out.println(beanName);
            return bean;
        }catch (BeanCreationException ex){
            System.out.println(ex.getStackTrace());
        }
        return null;
    }
}
