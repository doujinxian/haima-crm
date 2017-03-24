package com.haima.crm.service;

import com.haima.crm.entity.ComplaintFlow;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉审核信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
public interface ComplaintFlowService {
	
	ComplaintFlow queryObject(Integer id);
	
	List<ComplaintFlow> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintFlow complaintFlow);
	
	void update(ComplaintFlow complaintFlow);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
