package com.bo.spring.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description AOP环绕通知
 * @author 王博
 * @version 2017年8月30日　下午2:46:21
 */
public class DemoAroundAdvice implements MethodInterceptor{

	/**
	 * @param invocation 连接点
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("aroundAdvice start..");
        // 调用方法的参数  
        Object[] args = invocation.getArguments();  
        // 调用的方法  
        Method method = invocation.getMethod();  
        // 获取目标对象  
        Object target = invocation.getThis();  
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        Object returnValue = invocation.proceed();  
        System.out.println("参数:" + args[0] + ";目标方法:" + method + ";目标对象:" + target + ";返回值:" + returnValue);  
		System.out.println("aroundAdvice end..");
		return returnValue;
	}
	
}
