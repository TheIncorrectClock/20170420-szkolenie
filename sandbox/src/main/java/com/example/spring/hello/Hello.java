package com.example.spring.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Hello {

    private AtomicInteger cnt = new AtomicInteger(0);
    private final Translation translation;

    public Hello(Translation translation) {
        this.translation = translation;
    }

    public String sayHello(String name) {
        System.out.println("Current count = " + cnt.incrementAndGet());
        return translation.hello(name);
    }

}
