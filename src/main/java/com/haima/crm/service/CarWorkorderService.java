package com.haima.crm.service;

import com.haima.crm.entity.CarWorkorder;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
public interface CarWorkorderService {
	
	CarWorkorder queryObject(String vin);
	
	List<CarWorkorder> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CarWorkorder carWorkorder);
	
	void update(CarWorkorder carWorkorder);
	
	void delete(String vin);
	
	void deleteBatch(String[] vins);
}
