package com.haima.crm.service;

import com.haima.crm.entity.CarSeries;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public interface CarSeriesService {
	
	CarSeries queryObject(Integer carSeriesId);
	
	List<CarSeries> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CarSeries carSeries);
	
	void update(CarSeries carSeries);
	
	void delete(Integer carSeriesId);
	
	void deleteBatch(Integer[] carSeriesIds);
}
