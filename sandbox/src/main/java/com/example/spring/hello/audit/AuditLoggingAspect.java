package com.example.spring.hello.audit;

import com.example.spring.hello.Translation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditLoggingAspect {

    private Logger log = LoggerFactory.getLogger(AuditLoggingAspect.class);

    @Before(value = "execution(* com.example.spring.hello.Translation.*(*)) && args(arg)",
            argNames = "arg")
    public void logTranslation(JoinPoint jp, String arg) {
        log.info(jp.getTarget().getClass().getCanonicalName());
        String hello = ((Translation) jp.getTarget()).hello(arg);
        System.out.println("hello = " + hello);

        log.info("Performing translation for name={}", arg);
    }


}
