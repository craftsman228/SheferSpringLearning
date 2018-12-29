package com.begin.chapter4.JavaConfig;

import com.begin.chapter2.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandartMessageRenderer();
        renderer.setMessageProvider(messageProvider());

        return renderer;
    }
}
