package com.example.spring.hello;

class PolishTranslation implements Translation {
    public String hello(String name) {
        return String.format("Witaj, %s!", name);

    }
}
