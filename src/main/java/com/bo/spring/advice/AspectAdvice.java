package com.bo.spring.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * @Description spring切面类
 * @author 王博
 * @version 2017年8月31日　上午10:16:03
 */
public class AspectAdvice {
	
	/**在Spring中，任何通知（Advice）方法都可以将第一个参数定义为 org.aspectj.lang.JoinPoint类型用以接受当前连接点对象
	 * JoinPoint接口提供了一系列有用的方法, 如getArgs() （返回方法参数）、getThis() （返回代理对象）、getTarget() （返回目标对象）、
	 * getSignature() （返回正在被通知的方法相关信息）和  toString() （打印出正在被通知的方法的有用信息）
	 * */
	
	/**
	 * @Description 前置通知
	 * @param jp 连接点
	 * 方法中可声明其他参数，代表拦截方法的特征
	 */
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
	 */
	public void doAfter(JoinPoint jp){
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
	 * @param result 拦截返回类型为参数类型Object的方法,并将返回值注入到当前方法的形参result中
	 */
	public void doAfterReturn(JoinPoint jp, Object result){
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
	public void doAfterThrows(JoinPoint jp, Throwable e){
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
