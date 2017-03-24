package com.haima.crm.service;

import com.haima.crm.entity.ComplaintDelay;

import java.util.List;
import java.util.Map;

/**
 * 投诉延迟申请表
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
public interface ComplaintDelayService {
	
	ComplaintDelay queryObject(Integer id);
	
	List<ComplaintDelay> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintDelay complaintDelay);
	
	void update(ComplaintDelay complaintDelay);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
