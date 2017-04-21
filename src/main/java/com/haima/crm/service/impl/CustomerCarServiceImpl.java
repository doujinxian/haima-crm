package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CustomerCarDao;
import com.haima.crm.entity.CustomerCar;
import com.haima.crm.service.CustomerCarService;



@Service("customerCarService")
public class CustomerCarServiceImpl implements CustomerCarService {
	@Autowired
	private CustomerCarDao customerCarDao;
	
	@Override
	public CustomerCar queryObject(Long id){
		return customerCarDao.queryObject(id);
	}
	
	@Override
	public List<CustomerCar> queryList(Map<String, Object> map){
		return customerCarDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return customerCarDao.queryTotal(map);
	}
	
	@Override
	public void save(CustomerCar customerCar){
		customerCarDao.save(customerCar);
	}
	
	@Override
	public void update(CustomerCar customerCar){
		customerCarDao.update(customerCar);
	}
	
	@Override
	public void delete(Long id){
		customerCarDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		customerCarDao.deleteBatch(ids);
	}
	
}
