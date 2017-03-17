package com.haima.crm.service;

import com.haima.crm.entity.CustomerCarEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public interface CustomerCarService {
	
	CustomerCarEntity queryObject(Long customerId);
	
	List<CustomerCarEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomerCarEntity customerCar);
	
	void update(CustomerCarEntity customerCar);
	
	void delete(Long customerId);
	
	void deleteBatch(Long[] customerIds);
}
