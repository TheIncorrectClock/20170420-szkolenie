package com.example.spring.hello.audit;

import com.example.spring.App;
import com.example.spring.hello.HelloConfig;
import com.example.spring.hello.Translation;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.AppConfiguration.class)
@ActiveProfiles("polish")
public class AuditLoggingAspectSpringTest {

    @Autowired
    Translation translation;

    @Test
    public void should_run_aspect() {

        String str = translation.hello("Tom");
        assertThat(str, equalTo("Witaj, Jakub!"));
    }

}