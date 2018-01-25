package com.bo.spring.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description aspectj注解配置切面
 * @author 王博
 * @version 2017年8月31日　下午2:06:54
 */
@Component
@Aspect
public class AnnoAspectAdvice {
	
	/**在Spring中，任何通知（Advice）方法都可以将第一个参数定义为 org.aspectj.lang.JoinPoint类型用以接受当前连接点对象
	 * JoinPoint接口提供了一系列有用的方法, 如getArgs() （返回方法参数）、getThis() （返回代理对象）、getTarget() （返回目标对象）、
	 * getSignature() （返回正在被通知的方法相关信息）和  toString() （打印出正在被通知的方法的有用信息）
	 * */
	
	/**
	 * @Description 配置切入点：该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	 */
	@Pointcut("execution(* com.bo.spring.service.impl.*.*(..))")
	public void point_cut(){
		// 定义一个pointcut，下面用Annotation标注的通知方法可以公用这个pointcut
	}
	
	/**
	 * @Description 前置通知
	 * @param jp 连接点
	 */
//	@Before(value="point_cut()")
	@Before(value="execution(* com.bo.spring.service.impl.*.*(com.bo.spring.entity.Customer))") //拦截参数为com.bo.spring.entity.Customer的方法
	public void doBefore(JoinPoint jp){
		System.out.println("before advie start..");
		System.out.print("准备在"+jp.getTarget().getClass()+"对象上对");
		System.out.print(jp.getArgs()[0]+"参数调用");
		System.out.println(jp.getSignature().getName()+"方法");
		System.out.println("before advice end..");
	}
	
	/**
	 * @Description 后置通知1：目标方法执行后返回结果前 执行
	 * @param jp
	 * @param arg0 限制拦截有1个String类型参数的方法，并将参数值注入到当前方法的形参arg0中
	 */
	@After(value="point_cut() && args(arg0)")
	public void doAfter(JoinPoint jp,String arg0){
		System.out.println("after advie start..");
		// 获取被调用的类名
		String targetClassName = jp.getTarget().getClass().getName();
		// 获取被调用的方法名
		String targetMethodName = jp.getSignature().getName();
		// 日志格式字符串
		String logInfoText = "后置通知：" + targetClassName + "类的" + targetMethodName + "方法执行完毕.";
		// 将日志信息写入配置的文件中
		System.out.println(logInfoText);
		// logger.info(logInfoText);
		System.out.println("after advie end..");
	}
	
	/**
	 * @Description 后置通知2：目标方法返回结果后即执行
	 * @param jp
	 * @param result 拦截返回类型为参数类型String的方法,并将返回值注入到当前方法的形参result中
	 */
	@AfterReturning(pointcut="point_cut()",returning="result")
	public void doAfterReturn(JoinPoint jp, String result){
		System.out.println("after-return advice start..");
		System.out.println("目标对象:"+jp.getTarget().getClass());
		System.out.print("调用方法:"+jp.getSignature().getName());
		System.out.print("输入参数:"+jp.getArgs()[0]);
		System.out.println("返回值:"+result);
		System.out.println("after-return advice end..");
	}
	
	/**
	 * @Description 环绕通知
	 * @param jp
	 * @throws Throwable 
	 */
	@Around(value="point_cut()")
	public void doAround(ProceedingJoinPoint  pjp) throws Throwable{
		System.out.println("around advice start..");
		// 调用方法的参数  
        Object[] args = pjp.getArgs();  
        // 调用的方法  
        String method = pjp.getSignature().getName();  
        // 获取目标对象  
        Object target = pjp.getTarget();
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        long beginTime = System.currentTimeMillis();
        Object returnValue = pjp.proceed();
        long endTime = System.currentTimeMillis();
        // 日志格式字符串  
        String logInfoText = "环绕通知：" + method + "方法调用前时间" + beginTime  
                + "毫秒," + "调用后时间" + endTime + "毫秒";
        System.out.println(logInfoText);
		System.out.println("around advice end..");
	}
	
	/**
	 * @Description 异常通知
	 * @param jp
	 * @param e 拦截异常类型为参数e的类型的异常
	 */
	@AfterThrowing(pointcut="point_cut()",throwing="e")
	public void doAfterThrows(JoinPoint jp, NullPointerException e){
		// 获取被调用的类名  
        String targetClassName = jp.getTarget().getClass().getName();  
        // 获取被调用的方法名  
        String targetMethodName = jp.getSignature().getName();  
        // 日志格式字符串  
        String logInfoText = "异常通知：执行" + targetClassName + "类的"
        		+ targetMethodName + "方法时发生异常";
        System.out.println(logInfoText);
        // 将日志信息写入配置的文件中  
//        logger.info(logInfoText);
	}
	
}
