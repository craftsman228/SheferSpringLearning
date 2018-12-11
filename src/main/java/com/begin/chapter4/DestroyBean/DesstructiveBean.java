package com.begin.chapter4.DestroyBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

class DestructiveBean implements InitializingBean {

    private File file;
    private String path;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("destroy-bean.xml");
        context.refresh();

        DestructiveBean destructiveBean = (DestructiveBean) context.getBean("destructiveMethod");
        System.out.println("Calling destroy");
        destructiveBean.destroy();
        System.out.println("Calling was called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initing bean");
        if (path == null){
            throw new IllegalArgumentException("Specify file path" + DestructiveBean.class);
        }
        this.file = new File(path);
        this.file.createNewFile();
        System.out.println("File exists " + file.exists());
    }

    public void destroy(){
        System.out.println("Destroying process of bean");
        if (!file.delete()){
            System.err.println("ERROR: failed to delete file. ");
        }
        System.out.println("File exists " + file.exists());
    }

    public void setPath(String path) {
        this.path = path;
    }
}
