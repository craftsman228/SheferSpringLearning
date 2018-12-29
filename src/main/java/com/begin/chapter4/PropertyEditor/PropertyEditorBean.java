package com.begin.chapter4.PropertyEditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyEditorBean {

    private byte[] bytes;
    private Class cls;
    private Boolean trueOrFalse;
    private List<String> stringList;
    private Date date;
    private Float floatValue;
    private File file;
    private InputStream stream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String trimToString;
    private URL url;


    public void setBytes(byte[] bytes) {
        System.out.println("Setting bytes: " + bytes);
        this.bytes = bytes;
    }

    public void setCls(Class cls) {
        System.out.println("Setting cls: " + cls);
        this.cls = cls;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Setting trueOrFalse: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("Setting list: " + stringList);
        this.stringList = stringList;
    }

    public void setDate(Date date) {
        System.out.println("Setting date: " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("Setting floatValue: " + floatValue);
        this.floatValue = floatValue;
    }

    public void setFile(File file) {
        System.out.println("Setting file: " + file);
        this.file = file;
    }

    public void setStream(InputStream stream) {
        System.out.println("Setting stream: " + stream);
        this.stream = stream;
    }

    public void setLocale(Locale locale) {
        System.out.println("Setting locale: " + locale);
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        System.out.println("Setting properties: " + properties);
        this.properties = properties;
    }

    public void setTrimToString(String trimToString) {
        System.out.println("Setting trimToString: " + trimToString);
        this.trimToString = trimToString;
    }

    public void setUrl(URL url) {
        System.out.println("Setting url: " + url);
        this.url = url;
    }

    public static class CustomPropertyEditorRegistar implements PropertyEditorRegistrar {

        @Override
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ММ/dd/уууу");
            registry.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));

            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }

    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("property-editor.xml");
        context.refresh();

        PropertyEditorBean propertyEditorBean = (PropertyEditorBean) context.getBean("simpleBean");
    }


}
