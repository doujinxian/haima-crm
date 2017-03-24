package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CustomerContactDao;
import com.haima.crm.entity.CustomerContact;
import com.haima.crm.service.CustomerContactService;



@Service("customerContactService")
public class CustomerContactServiceImpl implements CustomerContactService {
	@Autowired
	private CustomerContactDao customerContactDao;
	
	@Override
	public CustomerContact queryObject(Long contactId){
		return customerContactDao.queryObject(contactId);
	}
	
	@Override
	public List<CustomerContact> queryList(Map<String, Object> map){
		return customerContactDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return customerContactDao.queryTotal(map);
	}
	
	@Override
	public void save(CustomerContact customerContact){
		customerContactDao.save(customerContact);
	}
	
	@Override
	public void update(CustomerContact customerContact){
		customerContactDao.update(customerContact);
	}
	
	@Override
	public void delete(Long contactId){
		customerContactDao.delete(contactId);
	}
	
	@Override
	public void deleteBatch(Long[] contactIds){
		customerContactDao.deleteBatch(contactIds);
	}
	
}
