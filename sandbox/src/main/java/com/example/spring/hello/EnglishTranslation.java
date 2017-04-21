package com.example.spring.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@HelloConfig.English
@Component
class EnglishTranslation implements Translation {
    public String hello(String name) {
        return String.format("Hello, %s!", name);
    }

}
