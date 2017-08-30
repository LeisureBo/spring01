package com.bo.demo.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @Description AOP后置通知
 * @author 王博
 * @version 2017年8月30日　下午2:39:53
 */
public class DemoAfterReturnAdvice implements AfterReturningAdvice{

	/**
	 * returnValue ：切入点执行完方法的返回值，但不能修改 <br> 
     * method ：切入点方法 <br> 
     * args ：切入点方法的参数数组 <br> 
     * target ：目标对象 
	 */
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("afterReturnAdvice start..");
		System.out.print(args[0] + "在");  
        System.out.print(target + "对象上被");  
        System.out.println(method + "方法删除了");
        System.out.println("afterReturnAdvice end..");
        
	}

}
