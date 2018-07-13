package com.stackroute.keepnote.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* Annotate this class with @Aspect and @Component */
@Aspect
@Component
public class LoggingAspect {

	/*
	 * Write loggers for each of the methods of controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
	private static final Logger log =LoggerFactory.getLogger(LoggingAspect.class);
    
    
	
	@Before("callFunctions()")
	public void beforeFunctionCalled(JoinPoint point) {
		log.info("before");
        //logger.in
        log.debug("Entering method " + point.getSignature().getName());
        
    
	}
	
	@After("callFunctions()")
	public void afterFunctionCalled(JoinPoint point) {
		log.info("after");
        //logger.in
        log.debug("Exiting method " + point.getSignature().getName() + "...");
    }
	
	@AfterReturning(value="callFunctions()",returning="result")
	public void afterReturningFunctionCalled(JoinPoint point, Object result ) {
		log.info("After Returning");
        //logger.in
        log.debug("Entering method " + point.getSignature().getName() + "...");
        log.debug("Method return : "+result);
	
	}
	@AfterThrowing(value="callFunctions()",throwing="error")
	public void afterThrowingFunctionCalled(JoinPoint point,Throwable error) {
		log.info("After Returning");
        //logger.in
        log.debug("Entering method " + point.getSignature().getName() + "...");
        log.error("Error : "+error);}
	
	@Pointcut("execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void callFunctions() {}
}
