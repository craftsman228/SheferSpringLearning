package com.begin.chapter4.JSR250Destroy;

import com.begin.chapter4.InterfaceDestroy.DestructiveBeanWithInterface;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PreDestroy;
import java.io.File;

public class AnnotatedDestroyedBean implements InitializingBean {

    private File file;
    private String path;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
        if (path == null){
            throw new IllegalArgumentException("Specify file path" + AnnotatedDestroyedBean.class);
        }
        this.file = new File(path);
        this.file.createNewFile();
        System.out.println("File " + file.exists());
    }

    @PreDestroy
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
        context.load("annotated-destroy.xml");
        context.refresh();

        AnnotatedDestroyedBean destructiveBean = (AnnotatedDestroyedBean) context.getBean("annotatedBean");
        System.out.println("run destroy...");
        destructiveBean.destroy();
        System.out.println("destroy completed");
    }
}
