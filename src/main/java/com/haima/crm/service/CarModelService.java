package com.haima.crm.service;

import java.util.List;
import java.util.Map;

import com.haima.crm.entity.CarModel;

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
	
	List<CarModel> queryList(CarModel carModel);
	
	int queryTotal(Map<String, Object> map);
	
	int queryTotal(CarModel carModel);
	
	void save(CarModel carModel);
	
	void update(CarModel carModel);
	
	void delete(Integer carModelId);
	
	void deleteBatch(Integer[] carModelIds);
}
