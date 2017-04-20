package com.example.spring;

import com.example.spring.hello.Hello;
import com.example.spring.hello.HelloConfig;
import com.example.spring.hello.events.EventsBasedHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;

public class App {

    private static Logger log = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext();
        factory.register(AppConfiguration.class);
        factory.getEnvironment().addActiveProfile("english");
        factory.refresh();

        EventsBasedHello bean = factory.getBean(EventsBasedHello.class);
        bean.hello("Jakub");
    }


}

@Configuration
@EnableAsync
@Import({HelloConfig.class})
class AppConfiguration {
}

