package com.example.spring.hello.events;

import com.example.spring.hello.Translation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventProcessor  {

    private static Logger log = LoggerFactory.getLogger(EventProcessor.class);

    @Autowired
    ApplicationEventPublisher publisher;

    private final Translation translation;

    public EventProcessor(Translation translation) {
        this.translation = translation;
    }

    @Async
    @EventListener
    public void processor(String name) throws InterruptedException {

        Thread.sleep(2000);

        String hello = translation.hello(name);
        log.info("hello = {}", hello);
        publisher.publishEvent(new Greeting(hello));
    }
}
