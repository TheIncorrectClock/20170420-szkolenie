package com.example.spring.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(HelloConfig.English.class))
public class HelloConfig {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Qualifier("polish")
    public @interface Polish {

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Qualifier("english")
    public @interface English {

    }

}

