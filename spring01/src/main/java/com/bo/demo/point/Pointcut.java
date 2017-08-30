package com.bo.demo.point;

import java.lang.reflect.Method;

import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @Description 定义一个切点，指定对应方法匹配。来供切面来针对方法进行处理
 * @author 王博
 * @version 2017年8月30日　下午4:13:15
 */
public class Pointcut extends NameMatchMethodPointcut {

	private static final long serialVersionUID = -5176979922701746611L;
	
	@Override
	public boolean matches(Method method, Class targetClass){
		// 设置单个方法匹配(支持*通配符)
//		this.setMappedName("delete*");
		// 设置多个方法匹配(支持*通配符)
		String[] methods = {"delete*","update*","add*"};
		this.setMappedNames(methods);
		return super.matches(method,targetClass);
	}
	
}
