package com.example.spring.hello.audit;

import com.example.spring.hello.Translation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AuditLoggingAspect {

    @Autowired
    Translation translation;

    private Logger log = LoggerFactory.getLogger(AuditLoggingAspect.class);

    @Around("execution(* com.example.spring.hello.Translation.*(*))")
    public Object aroundInvoke(ProceedingJoinPoint jp) throws Throwable {
        log.info("Around for {}", Arrays.asList(jp.getArgs()));

        return jp.proceed(new String[] {"Jakub"});
    }

    @Before(value = "execution(* com.example.spring.hello.Translation.*(*)) && args(arg)",
            argNames = "arg")
    public void logTranslation(JoinPoint jp, String arg) {
        log.info(jp.getTarget().getClass().getCanonicalName());
        String hello = ((Translation) jp.getTarget()).hello(arg);
        System.out.println("hello = " + hello);

        log.info("Performing translation for name={}", arg);
    }



}
