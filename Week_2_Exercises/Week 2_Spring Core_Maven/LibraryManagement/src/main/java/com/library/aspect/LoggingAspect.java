package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.library.service.*.*(..))")
    public void serviceMethods() {
        // Pointcut for all methods in the com.library.service package
    }

    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Executing method: " + joinPoint.getSignature().toShortString());
    }

    @After("serviceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Completed execution of method: " + joinPoint.getSignature().toShortString());
    }
}
