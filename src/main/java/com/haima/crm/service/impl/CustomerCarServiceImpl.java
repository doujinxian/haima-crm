package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CustomerCarDao;
import com.haima.crm.entity.CustomerCarEntity;
import com.haima.crm.service.CustomerCarService;



@Service("customerCarService")
public class CustomerCarServiceImpl implements CustomerCarService {
	@Autowired
	private CustomerCarDao customerCarDao;
	
	@Override
	public CustomerCarEntity queryObject(Long customerId){
		return customerCarDao.queryObject(customerId);
	}
	
	@Override
	public List<CustomerCarEntity> queryList(Map<String, Object> map){
		return customerCarDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return customerCarDao.queryTotal(map);
	}
	
	@Override
	public void save(CustomerCarEntity customerCar){
		customerCarDao.save(customerCar);
	}
	
	@Override
	public void update(CustomerCarEntity customerCar){
		customerCarDao.update(customerCar);
	}
	
	@Override
	public void delete(Long customerId){
		customerCarDao.delete(customerId);
	}
	
	@Override
	public void deleteBatch(Long[] customerIds){
		customerCarDao.deleteBatch(customerIds);
	}
	
}
