package com.example.dictionary.translation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TranslationServiceSpringTest.Cfg.class, TranslationService.class})
public class TranslationServiceSpringTest {

    @Autowired
    TranslationService service;

    @Test
    public void should_return_translations_for_book() {
        List<DictionaryWord> books = service.getTranslationsForWord("book");

        assertThat(books, hasSize(24));
        assertThat(books.get(0), equalTo(new DictionaryWord("książka", "book")));
    }

    @Configuration
    public static class Cfg {

        @Bean
        public PropertyPlaceholderConfigurer properties(ApplicationContext ctx) throws IOException {
            Resource resource = ctx.getResource("classpath:/words/book.html");
            final String fileLocation = resource.getURL().toExternalForm();

            Properties ps = new Properties();
            ps.setProperty("url.dict.pl", fileLocation);

            PropertyPlaceholderConfigurer p = new PropertyPlaceholderConfigurer();
            p.setProperties(ps);
            return p;
        }

    }

}

