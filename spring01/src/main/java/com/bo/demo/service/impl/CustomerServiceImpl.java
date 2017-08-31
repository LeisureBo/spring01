package com.bo.demo.service.impl;

import org.springframework.stereotype.Component;

import com.bo.demo.entity.Customer;
import com.bo.demo.service.CustomerService;

/**
 * @Description 业务方法实现
 * @author 王博
 * @version 2017年8月30日　下午2:54:10
 */
@Component
public class CustomerServiceImpl implements CustomerService {

	@Override
	public void delete(Customer customer) {
		int i = 1/0;
		System.out.println("正在删除客户:"+customer.getName()+" ..");
	}

	@Override
	public void add(Customer customer) {
		System.out.println("正在添加客户:"+customer.getName()+" ..");
	}

	@Override
	public void update(Customer customer) {
		System.out.println("正在更新客户:"+customer.getName()+" ..");
	}

	@Override
	public void testSay(String content) {
		System.out.println("You said '"+content+"' ..");
	}

	@Override
	public Integer testRecharge(Double money) {
		int ret = 1;
		System.out.println("You have recharged $"+money);
		return ret;
	}

	
}
