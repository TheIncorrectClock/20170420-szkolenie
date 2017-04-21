package com.example.spring.hello.audit;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLoggingAspect {

    private Logger log = LoggerFactory.getLogger(AuditLoggingAspect.class);

    @Before("execution(* com.example.spring.hello.Translation.*(*))")
    public void logTranslation() {
        log.info("Performing translation");
    }


}
