package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CustomerDao;
import com.haima.crm.entity.CustomerEntity;
import com.haima.crm.service.CustomerService;



@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public CustomerEntity queryObject(Long customerId){
		return customerDao.queryObject(customerId);
	}
	
	@Override
	public List<CustomerEntity> queryList(Map<String, Object> map){
		return customerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return customerDao.queryTotal(map);
	}
	
	@Override
	public void save(CustomerEntity customer){
		customerDao.save(customer);
	}
	
	@Override
	public void update(CustomerEntity customer){
		customerDao.update(customer);
	}
	
	@Override
	public void delete(Long customerId){
		customerDao.delete(customerId);
	}
	
	@Override
	public void deleteBatch(Long[] customerIds){
		customerDao.deleteBatch(customerIds);
	}
	
}
