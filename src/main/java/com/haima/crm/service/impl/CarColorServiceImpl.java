package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CarColorDao;
import com.haima.crm.entity.CarColor;
import com.haima.crm.service.CarColorService;



@Service("carColorService")
public class CarColorServiceImpl implements CarColorService {
	@Autowired
	private CarColorDao carColorDao;
	
	@Override
	public CarColor queryObject(Long id){
		return carColorDao.queryObject(id);
	}
	
	@Override
	public List<CarColor> queryList(Map<String, Object> map){
		return carColorDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return carColorDao.queryTotal(map);
	}
	
	@Override
	public void save(CarColor carColor){
		carColorDao.save(carColor);
	}
	
	@Override
	public void update(CarColor carColor){
		carColorDao.update(carColor);
	}
	
	@Override
	public void delete(Long id){
		carColorDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		carColorDao.deleteBatch(ids);
	}
	
}
