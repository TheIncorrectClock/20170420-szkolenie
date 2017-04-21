package com.example.spring.hello.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuditLoggingAspectTest {

    @Mock
    Logger logger;

    @InjectMocks
    AuditLoggingAspect aspect;

    @Test
    public void should_log_method_aroundInvoke() throws Throwable {
        ProceedingJoinPoint mock = mock(ProceedingJoinPoint.class);
        when(mock.getArgs()).thenReturn(new String[] {"Tom"});

        aspect.aroundInvoke(mock);

        verify(logger).info("Around for {}", Arrays.asList("Tom"));
        verify(mock).proceed(new String[] {"Jakub"});
    }

}