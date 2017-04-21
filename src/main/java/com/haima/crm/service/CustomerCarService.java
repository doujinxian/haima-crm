package com.haima.crm.service;

import com.haima.crm.entity.CustomerCar;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
public interface CustomerCarService {
	
	CustomerCar queryObject(Long id);
	
	List<CustomerCar> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomerCar customerCar);
	
	void update(CustomerCar customerCar);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
