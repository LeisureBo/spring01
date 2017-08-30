package com.bo.demo.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.aop.ThrowsAdvice;

/**
 * @Description AOP异常通知类
 * @author 王博
 * @version 2017年8月30日　下午2:42:08
 */
public class DemoAfterThrowsAdvice implements ThrowsAdvice{
	
	/**
		异常增强实现的接口中没有指定任何方法，方法需自定义，方法名需指定为:afterThrowing
		但是Spring指定了该方法必须使用的参数列表:
		Method method：切入的方法(可选)
		Object[] args：切入方法的方法参数(可选)
		Object target：目标对象(可选)
		Exception ex：异常子类，出现这个异常类的子类，则会进入这个通知(必填) 
		应用:记录异常日志、事务出错回滚。
	 */
	public void afterThrowing(Method method,Object[] args,Object target,Exception ex){
		/**该方法在目标方法内部出现异常时执行,故不要再此执行目标方法,可记录异常日志*/
		System.out.println(new Date()+" : "+method.getName()+"出现异常:"+ex.getMessage());
	}
}
