package com.aspect.oriented;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
@Component // * issue here
@Slf4j // * issue here
public class LoggingAspect {
    // I want this method to run before the get
    // this is the aspect configuration
    @Pointcut("execution (* com.aspect.oriented.ActorController.Get*(..))")
    public void allControllerGetMethods() {
    }

    @Before("allControllerGetMethods()")
    // * joinpoint not found here
    // * EnableAspectAutoProxy
    // * PointCut cldnt be found
    // * before and after as well
    public void logBefore(JoinPoint joinPt) {
        System.out.println("This came from the aspect");
    }

    @AfterReturning(pointcut = "allControllerGetMethods()", returning = "result")
    public void logAfter(JoinPoint joinPt, Object result) {
        System.out.println("This came from aspect after processing");
    }

}
