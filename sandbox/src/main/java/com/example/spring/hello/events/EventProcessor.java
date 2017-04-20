package com.example.spring.hello.events;

import com.example.spring.hello.Translation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class EventProcessor  {

    private static Logger log = LoggerFactory.getLogger(EventProcessor.class);

    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    Validator validator;

    private final Translation translation;

    public EventProcessor(Translation translation) {
        this.translation = translation;
    }

    @Async
    @EventListener
    public void processor(Name name) throws InterruptedException {

        Set<ConstraintViolation<Name>> violations = validator.validate(name);
        System.out.println("violations = " + violations);

        if (!violations.isEmpty()) {
            publisher.publishEvent("Błąd walidacji " + name.word);
            return;
        }

        String hello = translation.hello(name.word);
        log.info("hello = {}", hello);
        publisher.publishEvent(new Greeting(hello));
    }
}
