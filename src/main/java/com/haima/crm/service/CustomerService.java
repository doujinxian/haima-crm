package com.haima.crm.service;

import com.haima.crm.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public interface CustomerService {
	
	CustomerEntity queryObject(Long customerId);
	
	List<CustomerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomerEntity customer);
	
	void update(CustomerEntity customer);
	
	void delete(Long customerId);
	
	void deleteBatch(Long[] customerIds);
}
