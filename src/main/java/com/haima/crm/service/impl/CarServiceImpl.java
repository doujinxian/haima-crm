package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CarDao;
import com.haima.crm.entity.Car;
import com.haima.crm.service.CarService;



@Service("carService")
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDao carDao;
	
	@Override
	public Car queryObject(Integer carId){
		return carDao.queryObject(carId);
	}
	
	@Override
	public List<Car> queryList(Map<String, Object> map){
		return carDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return carDao.queryTotal(map);
	}
	
	@Override
	public void save(Car car){
		carDao.save(car);
	}
	
	@Override
	public void update(Car car){
		carDao.update(car);
	}
	
	@Override
	public void delete(Integer carId){
		carDao.delete(carId);
	}
	
	@Override
	public void deleteBatch(Integer[] carIds){
		carDao.deleteBatch(carIds);
	}
	
}
