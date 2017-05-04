package com.haima.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haima.crm.dao.CarModelDao;
import com.haima.crm.entity.CarModel;
import com.haima.crm.service.CarModelService;



@Service("carModelService")
public class CarModelServiceImpl implements CarModelService {
	@Autowired
	private CarModelDao carModelDao;
	
	@Override
	public CarModel queryObject(Integer carModelId){
		return carModelDao.queryObject(carModelId);
	}
	
	@Override
	public List<CarModel> queryList(Map<String, Object> map){
		return carModelDao.queryList(map);
	}
	
	@Override
	public List<CarModel> queryList(CarModel carModel) {
		return carModelDao.queryList(carModel);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return carModelDao.queryTotal(map);
	}
	
	@Override
	public int queryTotal(CarModel carModel) {
		return carModelDao.queryTotal(carModel);
	}
	
	@Override
	public void save(CarModel carModel){
		carModelDao.save(carModel);
	}
	
	@Override
	public void update(CarModel carModel){
		carModelDao.update(carModel);
	}
	
	@Override
	public void delete(Integer carModelId){
		carModelDao.delete(carModelId);
	}
	
	@Override
	public void deleteBatch(Integer[] carModelIds){
		carModelDao.deleteBatch(carModelIds);
	}
	
}
