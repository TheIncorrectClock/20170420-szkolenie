package com.example.spring.hello.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventsBasedHello {

    private static Logger log = LoggerFactory.getLogger(EventsBasedHello.class);

    @Autowired
    ApplicationEventPublisher publisher;

    public void hello(String name) {
        publisher.publishEvent(new Name(name));
    }

    @EventListener
    public void receviedGreeting(String g) {
        log.info("name = {}", g);
    }

    @EventListener
    public void receviedGreeting(Greeting g) {
        log.info("greeting = {}", g.translation);
    }

}
