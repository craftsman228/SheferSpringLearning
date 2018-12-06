package com.begin.chapter3.ValueInjection;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSpel {
    private String name;
    private int age;
    private float height;
    private boolean isProgrammer;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return isProgrammer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        isProgrammer = programmer;
    }


    @Override
    public String toString() {
        return "InjectSimple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", isProgrammer=" + isProgrammer +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("inject-simple.xml");
        context.refresh();
        InjectSpel injectSpel = (InjectSpel) context.getBean("injectSpel");
        System.out.println(injectSpel);
    }
}
