package com.begin.chapter4.InterfaceDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.io.File;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {

    private File file;
    private String path;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
        if (path == null){
            throw new IllegalArgumentException("Specify file path" + DestructiveBeanWithInterface.class);
        }
        this.file = new File(path);
        this.file.createNewFile();
        System.out.println("File " + file.exists());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying process of bean");
        if (!file.delete()){
            System.err.println("ERROR: failed to delete file. ");
        }
        System.out.println("File exists " + file.exists());
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("destroy-bean-interface.xml");
        context.refresh();

        DestructiveBeanWithInterface destructiveBean = (DestructiveBeanWithInterface) context.getBean("destructiveMethodWithInterface");
        System.out.println("run destroy...");
        destructiveBean.destroy();
        System.out.println("destroy completed");

    }
}
