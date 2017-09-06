package com.bo.demo.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bo.demo.entity.Customer;
import com.bo.demo.service.CustomerService;

/**
 * @Description AOP测试
 * @author 王博
 * @version 2017年8月30日　下午3:45:19
 */
public class CustomerServiceImplTest {

	private static ApplicationContext ctx;
	private CustomerService customerService;
	
	/**
	 * @Description 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring/spring-aop-4.xml");
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
		// spring aop实现1(配置文件1+2)
//		customerService = (CustomerService) ctx.getBean("customerServiceProxy");
		// spring aop实现2(配置文件3)
//		customerService = (CustomerService) ctx.getBean("customerService");
		// spring aop实现3(配置文件4)
		customerService = (CustomerService) ctx.getBean("customerServiceImpl");
	}

	/**
	 * @Description 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.bo.demo.service.impl.CustomerServiceImpl#delete(com.bo.demo.entity.Customer)}.
	 */
	@Test
	public void testAOP() {
//		customerService.delete(new Customer("xiaoMing","男",23));
//		customerService.add(new Customer("xiaoMei","女",23));
//		customerService.update(new Customer("Shan","女",24));
//		customerService.testSay("I'm learning spring AOP");
		customerService.testRecharge(100d);
	}

}
