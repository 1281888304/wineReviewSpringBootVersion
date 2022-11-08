package com.example.wines.Config;

import ch.qos.logback.classic.Logger;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopConfig {

//  @Pointcut(* com.example..service.*.*(..))")
//  public void pointcut(){
//
//  }

  //@Around("execution( com.example.wines.service.impl(...))")
//  @Around(value = "execution(* com.example.wines.service.impl.*.*(..))", argNames = "proceedingJoinPoint,joinPoint")
//  public Object methodBefore(ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint){
//    log.info("method before invoke");
//    Object[] args= joinPoint.getArgs();
//    Signature signature = joinPoint.getSignature();
//    String name = signature.getName();
//
//    log.info("Object "+joinPoint.getTarget()+"method "+name+" args: "+ Arrays.toString(args));
//    Object proceed;
//    try {
//       proceed = proceedingJoinPoint.proceed();
//    } catch (Throwable throwable) {
//      System.out.println(name+ "invoke fail");
//      throw new RuntimeException("method invoke with error");
//    }
//    return proceed;
//
//
//  }
  @AfterThrowing(value = "execution(* com.example.wines.service.impl.*.*(..))")
  public void methodThrow(JoinPoint joinPoint)  {
    System.out.println("bug on "+joinPoint.getTarget()+" "+joinPoint.getSignature().getName());



  }



  @Before("execution(* com.example.wines.service.impl.*.*(..))")
  public void beforeAop(JoinPoint joinPoint){
    System.out.println( joinPoint.getTarget());
    System.out.println(joinPoint.getSignature().getName());

  }

}
