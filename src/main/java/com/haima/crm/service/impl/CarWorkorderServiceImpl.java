package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CarWorkorderDao;
import com.haima.crm.entity.CarWorkorder;
import com.haima.crm.service.CarWorkorderService;



@Service("carWorkorderService")
public class CarWorkorderServiceImpl implements CarWorkorderService {
	@Autowired
	private CarWorkorderDao carWorkorderDao;
	
	@Override
	public CarWorkorder queryObject(String vin){
		return carWorkorderDao.queryObject(vin);
	}
	
	@Override
	public List<CarWorkorder> queryList(Map<String, Object> map){
		return carWorkorderDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return carWorkorderDao.queryTotal(map);
	}
	
	@Override
	public void save(CarWorkorder carWorkorder){
		carWorkorderDao.save(carWorkorder);
	}
	
	@Override
	public void update(CarWorkorder carWorkorder){
		carWorkorderDao.update(carWorkorder);
	}
	
	@Override
	public void delete(String vin){
		carWorkorderDao.delete(vin);
	}
	
	@Override
	public void deleteBatch(String[] vins){
		carWorkorderDao.deleteBatch(vins);
	}
	
}
