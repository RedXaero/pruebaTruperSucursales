package com.micro.truper.sucursales.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@ConditionalOnExpression("${aspect.enable:true}")
public class ExecutionTimeAdvice {

    @Around("@annotation(com.micro.truper.sucursales.config.TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long inicio = System.currentTimeMillis();
        Object object = point.proceed();
        long fin = System.currentTimeMillis();
        log.info("-------------->");
        log.info("----- Executed methoid: "+ point.getSignature().getName() + ". Time taken for Execution is : " + (fin-inicio) +"ms");
        log.info("--------------<");
        return object;
    }
}
