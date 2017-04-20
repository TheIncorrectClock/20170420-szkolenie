package com.example.spring.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@HelloConfig.Polish
@Component
class PolishTranslation implements Translation {

    public String hello(String name) {
        return String.format("Witaj, %s!", name);

    }
}
