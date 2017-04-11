package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CarSeriesDao;
import com.haima.crm.entity.CarSeries;
import com.haima.crm.service.CarSeriesService;



@Service("carSeriesService")
public class CarSeriesServiceImpl implements CarSeriesService {
	@Autowired
	private CarSeriesDao carSeriesDao;
	
	@Override
	public CarSeries queryObject(Integer carSeriesId){
		return carSeriesDao.queryObject(carSeriesId);
	}
	
	@Override
	public List<CarSeries> queryList(Map<String, Object> map){
		return carSeriesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return carSeriesDao.queryTotal(map);
	}
	
	@Override
	public void save(CarSeries carSeries){
		carSeriesDao.save(carSeries);
	}
	
	@Override
	public void update(CarSeries carSeries){
		carSeriesDao.update(carSeries);
	}
	
	@Override
	public void delete(Integer carSeriesId){
		carSeriesDao.delete(carSeriesId);
	}
	
	@Override
	public void deleteBatch(Integer[] carSeriesIds){
		carSeriesDao.deleteBatch(carSeriesIds);
	}
	
}
