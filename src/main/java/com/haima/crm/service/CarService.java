package com.haima.crm.service;

import com.haima.crm.entity.Car;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:29
 */
public interface CarService {
	
	Car queryObject(Integer carId);
	
	List<Car> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Car car);
	
	void update(Car car);
	
	void delete(Integer carId);
	
	void deleteBatch(Integer[] carIds);
}
