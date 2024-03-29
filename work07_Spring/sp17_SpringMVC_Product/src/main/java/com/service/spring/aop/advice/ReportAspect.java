package com.service.spring.aop.advice;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.service.spring.aop.model.ReportService;

@Component
@Aspect
@EnableAspectJAutoProxy
public class ReportAspect {
	@Autowired
	private ReportService reportService;
	
	@Around("execution(* com.service..*Service*.find*(String))")
	public Object report(ProceedingJoinPoint pjp) throws Throwable{
		Object retValue;
		
		retValue = pjp.proceed(); // target이 호출될 때 proceed가 호출된다
		System.out.println("proceed() call ... target ");
		
		List list  = (List)retValue;
		
		if(!list.isEmpty()) {
			Object[] params = pjp.getArgs();
			reportService.saveReport(params[0].toString());
		}
		return list;
		
	}
	
	
}
