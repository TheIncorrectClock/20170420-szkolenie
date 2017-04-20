package com.example.spring.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Primary
@Component
class EnglishTranslation implements Translation {
    public String hello(String name) {
        return String.format("Hello, %s!", name);
    }
}
