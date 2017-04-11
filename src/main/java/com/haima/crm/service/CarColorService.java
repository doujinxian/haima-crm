package com.haima.crm.service;

import com.haima.crm.entity.CarColor;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public interface CarColorService {
	
	CarColor queryObject(Long id);
	
	List<CarColor> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CarColor carColor);
	
	void update(CarColor carColor);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
