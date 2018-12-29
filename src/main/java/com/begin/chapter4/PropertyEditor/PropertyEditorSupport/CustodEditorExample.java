package com.begin.chapter4.PropertyEditor.PropertyEditorSupport;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustodEditorExample {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("support-property-editor.xml");
        context.refresh();

        CustodEditorExample custodEditorExample = (CustodEditorExample) context.getBean("exampleBean");
        System.out.println(custodEditorExample.getUser());
    }
}
