package com.capgemini.boardgames.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(Aspect.class);

    @Around("execution(* com.capgemini.boardgames.repository.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        LOGGER.info("Method findById execution time: " + elapsedTime + " milliseconds.");
        return output;
    }
}
