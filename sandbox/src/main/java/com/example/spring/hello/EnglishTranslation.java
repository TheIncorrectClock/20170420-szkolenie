package com.example.spring.hello;

import org.springframework.stereotype.Component;

@Component
class EnglishTranslation implements Translation {
    public String hello(String name) {
        return String.format("Hello, %s!", name);
    }
}
