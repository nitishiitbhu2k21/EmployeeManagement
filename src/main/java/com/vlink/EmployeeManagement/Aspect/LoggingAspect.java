package com.vlink.EmployeeManagement.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.vlink.EmployeeManagement.Service.*.*(..))")
    public void logBeforeServiceMethods() {
        logger.info("Executing Service Method...");
    }

    // Log after method execution
    @After("execution(* com.vlink.EmployeeManagement.Service.*.*(..))")
    public void logAfterServiceMethods() {
        logger.info("Service Method Execution Completed.");
    }

    // Performance monitoring for all repository and service methods
    @Around("execution(* com.vlink.EmployeeManagement.Service.*.*(..)) || execution(* com.vlink.EmployeeManagement.Repository.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();  // Proceed with the actual method execution

        long duration = System.currentTimeMillis() - start;
        logger.info("Execution Time of {}: {} ms", joinPoint.getSignature(), duration);

        return result;
    }
}

