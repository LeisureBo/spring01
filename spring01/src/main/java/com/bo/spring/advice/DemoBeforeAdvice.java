package com.bo.spring.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * @Description AOP前置通知
 * @author 王博
 * @version 2017年8月30日　下午2:38:14
 */
public class DemoBeforeAdvice implements MethodBeforeAdvice{

	/** 
     * method : 切入的方法 <br> 
     * args ：切入方法的参数 <br> 
     * target ：目标对象 
     */  
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("beforeAdvice start..");
		System.out.print("准备在" + target + "对象上用");  
        System.out.print(method + "方法进行对 '");  
        System.out.println(args[0] + "'进行删除！"); 
		System.out.println("beforeAdvice end..");
	}
	
}
