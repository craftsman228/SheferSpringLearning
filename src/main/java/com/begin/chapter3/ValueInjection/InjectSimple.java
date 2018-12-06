package com.begin.chapter3.ValueInjection;

public class InjectSimple {
    private String name = "Marfa";
    private int age = 12;
    private float height = 5;
    private boolean isProgrammer = false;

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
}
