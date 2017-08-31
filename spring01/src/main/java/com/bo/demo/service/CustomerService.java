package com.bo.demo.service;

import com.bo.demo.entity.Customer;

/**
 * @Description 业务接口
 * @author 王博
 * @version 2017年8月30日　下午2:52:16
 */
public interface CustomerService {
	/**
	 * @Description 用作代理的切入点方法
	 * @param customer
	 */
	public void delete(Customer customer);
	
	public void add(Customer customer);
	
	public void update(Customer customer);
	
	public void testSay(String content);
	
	public Integer testRecharge(Double money);
}
