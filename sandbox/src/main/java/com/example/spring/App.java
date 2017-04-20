package com.example.spring;

import com.example.spring.hello.Hello;
import com.example.spring.hello.HelloConfig;
import com.example.spring.hello.Translation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        ApplicationContext factory = new AnnotationConfigApplicationContext(HelloConfig.class);

        Hello hello = factory.getBean(Hello.class);
        System.out.println("hello = " + hello.sayHello("Jakub"));
    }

}

