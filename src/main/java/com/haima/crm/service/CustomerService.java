package com.haima.crm.service;

import com.haima.crm.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
public interface CustomerService {
	
	Customer queryObject(Long customerId);
	
	List<Customer> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(Long customerId);
	
	void deleteBatch(Long[] customerIds);
}
