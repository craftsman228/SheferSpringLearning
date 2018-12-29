package com.begin.chapter4.MessageSource;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("message-source.xml");
        context.refresh();

        Locale english = Locale.ENGLISH;
        Locale checz = new Locale("cs", "CZ");

        System.out.println(context.getMessage("msg", null, english));
        System.out.println(context.getMessage("msg", null, checz));

        System.out.println(context.getMessage("nameMsg", new Object[]{"Chris", "Obobo" }, english));
    }
}
