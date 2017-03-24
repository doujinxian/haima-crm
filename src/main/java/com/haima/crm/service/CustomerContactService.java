package com.haima.crm.service;

import com.haima.crm.entity.CustomerContact;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
public interface CustomerContactService {
	
	CustomerContact queryObject(Long contactId);
	
	List<CustomerContact> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CustomerContact customerContact);
	
	void update(CustomerContact customerContact);
	
	void delete(Long contactId);
	
	void deleteBatch(Long[] contactIds);
}
