package com.sadigov.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLogAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Pointcut that matches all methods with @Timed annotation.
     */
    @Pointcut("@annotation(com.sadigov.aspects.Timed)")
    public void timePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Around("timePointcut()")
    public Object time(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object object;

        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            long duration = System.currentTimeMillis() - startTime;

            log.info(
                    "Time: {}.{} took {} ms",
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(),
                    duration);
        }

        return object;
    }
}
