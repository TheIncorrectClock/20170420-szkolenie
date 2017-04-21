package com.example.dictionary.audit;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before(value = "execution(* com.example..TranslationService.getTranslationsForWord(*))" +
            "&& args(word)", argNames = "word")
    public void logTranslationInvocation(String word) {
        log.info("Translating {}", word);
    }

}
