package com.example.spring.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.lang.annotation.*;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Translation.class))
@Import({PolishConfig.class, EnglishConfig.class})
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


@Profile("polish")
class PolishConfig {

    @Bean
    Translation polish() { return new PolishTranslation();}

}

@Profile("english")
class EnglishConfig {

    @Bean
    Translation polish() { return new EnglishTranslation();}
}