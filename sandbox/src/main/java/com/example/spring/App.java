package com.example.spring;

import com.example.spring.hello.Hello;
import com.example.spring.hello.HelloConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.IOException;

public class App {

    private static Logger log = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) throws IOException {

        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfiguration.class);

        Hello hello = factory.getBean(Hello.class);
        log.info("hello({}) = {}", hello.hashCode(), hello.sayHello("Jakub"));
    }


}

@Configuration
@Import({HelloConfig.class})
class AppConfiguration {
}

