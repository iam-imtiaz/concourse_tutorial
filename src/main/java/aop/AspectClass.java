package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
	
	@Before("execution( * *(..))")
	
	public void log(JoinPoint joinPoint) {
		System.out.println("Logging before invocation of "+ joinPoint.getSignature());
	}
	

	@AfterThrowing("execution( * *(..) throws Exception)")
	
	public void log1(JoinPoint joinPoint) {
		System.out.println("Logging before invocation of "+ joinPoint.getSignature());
	}
}
