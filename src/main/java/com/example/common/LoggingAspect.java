package com.example.common;

import com.example.RestServiceApplication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger =
            LoggerFactory.getLogger(RestServiceApplication.class);

    @Around("execution(* *..*Controller.*(..))")
    public void requestLog(JoinPoint joinPoint) {
    }
}
