package com.haima.crm.service;

import com.haima.crm.entity.CarModel;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public interface CarModelService {
	
	CarModel queryObject(Integer carModelId);
	
	List<CarModel> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CarModel carModel);
	
	void update(CarModel carModel);
	
	void delete(Integer carModelId);
	
	void deleteBatch(Integer[] carModelIds);
}
