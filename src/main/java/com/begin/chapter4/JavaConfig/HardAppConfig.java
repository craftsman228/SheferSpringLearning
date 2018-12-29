package com.begin.chapter4.JavaConfig;

import com.begin.chapter2.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource(value = "classpath: pre-java-conf.xml")
@PropertySource(value = "classpath: message.properties")
@ComponentScan(basePackages = "com.begin.chapter4")
@EnableTransactionManagement
public class HardAppConfig {

    @Autowired
    Environment environment;

    @Bean
    @Lazy(value = true)
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    @Bean
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandartMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }
}
