package com.server.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {

	public void doBefore(JoinPoint jp){
		System.out.print("do Before");
		System.out.print("类名："+jp.getTarget().getClass().getName());
		System.out.print("方法名："+jp.getSignature().getName());
		System.out.println("参数信息："+jp.getArgs()[0]);
	}
	
	public void doAfter(JoinPoint jp){
		System.out.print("do after");
		System.out.print("类名："+jp.getTarget().getClass().getName());
		System.out.print("方法名："+jp.getSignature().getName());
		System.out.println("参数信息："+jp.getArgs()[0]);
	}
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("doAroundBefore");
		Object retVal=pjp.proceed();
		System.out.println("doAroundAfter");
		return retVal;
	}
}
