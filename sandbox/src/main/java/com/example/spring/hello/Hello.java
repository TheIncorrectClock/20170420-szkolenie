package com.example.spring.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class Hello {

    private Translation translation;

    public Hello(Translation translation) {
        this.translation = translation;
    }

    public String sayHello(String name) {
        return translation.hello(name);
    }

}
