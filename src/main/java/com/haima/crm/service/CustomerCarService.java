package com.haima.crm.service;

import com.haima.crm.entity.CustomerCar;

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
	
	CustomerCar queryObject(Long customerId);
	
	List<CustomerCar> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomerCar customerCar);
	
	void update(CustomerCar customerCar);
	
	void delete(Long customerId);
	
	void deleteBatch(Long[] customerIds);
}
