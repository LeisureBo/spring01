package com.bo.spring.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bo.spring.controller.HelloWorld;

/**
 * @Description 
 * @author 王博
 * @version 2017年8月30日　上午11:43:15
 */
public class HelloWorldTest {

	private static ApplicationContext ctx;
	
	private HelloWorld helloWorld;
	
	/**
	 * @Description 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	/**
	 * @Description 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @Description 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		helloWorld = (HelloWorld) ctx.getBean("helloWorld");
	}

	/**
	 * @Description 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.bo.spring.controller.HelloWorld#sayHello()}.
	 */
	@Test
	public void testSayHello() {
		helloWorld.sayHello();//测试方法..
	}

}
