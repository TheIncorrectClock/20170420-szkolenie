package com.example.spring;

import com.example.spring.hello.Hello;
import com.example.spring.hello.HelloConfig;
import com.example.spring.hello.events.EventsBasedHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;

public class App {

    private static Logger log = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext(Foo.class);

        AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext();
        factory.setParent(parent);
        factory.register(AppConfiguration.class);
        factory.getEnvironment().addActiveProfile("polish");
        factory.refresh();

        Foo bean1 = factory.getBean(Foo.class);
        System.out.println("bean1 = " + bean1.bar());

        EventsBasedHello bean = factory.getBean(EventsBasedHello.class);
        bean.hello("Tom");
    }

    @Configuration
    @EnableAsync
    @EnableAspectJAutoProxy
    @Import({HelloConfig.class})
    public static class AppConfiguration {

        @Bean
        public Validator validator() {
//        return new LocalValidatorFactoryBean();
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            return validatorFactory.getValidator();
        }

    }


}

