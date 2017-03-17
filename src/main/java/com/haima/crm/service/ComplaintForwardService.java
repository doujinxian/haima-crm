package com.haima.crm.service;

import com.haima.crm.entity.ComplaintForwardEntity;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉转发信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public interface ComplaintForwardService {
	
	ComplaintForwardEntity queryObject(Integer id);
	
	List<ComplaintForwardEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintForwardEntity complaintForward);
	
	void update(ComplaintForwardEntity complaintForward);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
