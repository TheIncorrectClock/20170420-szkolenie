package com.example.spring.hello;

import org.springframework.stereotype.Component;


@Component
class PolishTranslation implements Translation {
    public String hello(String name) {
        return String.format("Witaj, %s!", name);

    }
}
