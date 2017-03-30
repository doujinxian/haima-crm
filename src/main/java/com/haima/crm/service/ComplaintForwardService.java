package com.haima.crm.service;

import com.haima.crm.entity.ComplaintForward;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉转发信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-30 19:39:58
 */
public interface ComplaintForwardService {
	
	ComplaintForward queryObject(Integer id);
	
	List<ComplaintForward> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintForward complaintForward);
	
	void update(ComplaintForward complaintForward);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
