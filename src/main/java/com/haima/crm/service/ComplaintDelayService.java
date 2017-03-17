package com.haima.crm.service;

import com.haima.crm.entity.ComplaintDelayEntity;

import java.util.List;
import java.util.Map;

/**
 * 投诉延迟申请表
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public interface ComplaintDelayService {
	
	ComplaintDelayEntity queryObject(Integer id);
	
	List<ComplaintDelayEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintDelayEntity complaintDelay);
	
	void update(ComplaintDelayEntity complaintDelay);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
