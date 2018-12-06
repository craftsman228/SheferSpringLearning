package com.begin.chapter3.InjectCollection;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {

    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("collection.xml");
        context.refresh();
        CollectionInjection collectionInjection = (CollectionInjection) context.getBean("injectCollection");
        collectionInjection.displayInfo();
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void displayInfo(){
        System.out.println("Map content: \n");
        for (Map.Entry<String, Object> entry: map.entrySet()){
            System.out.println("key: " + entry.getKey() + " value" + entry.getValue());
        }

        System.out.println("Props content: \n");
        for (Map.Entry<Object, Object> entry: props.entrySet()){
            System.out.println("key: " + entry.getKey() + " value" + entry.getValue());
        }

        System.out.println("Set content: \n");
        for (Object obj: set){
            System.out.println("Value " + obj);
        }

        System.out.println("List content: \n");
        for (Object obj: list){
            System.out.println("Val list " + obj);
        }
    }
}
