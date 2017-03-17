package com.haima.crm.service;

import com.haima.crm.entity.ComplaintFlowEntity;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉审核信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public interface ComplaintFlowService {
	
	ComplaintFlowEntity queryObject(Integer id);
	
	List<ComplaintFlowEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintFlowEntity complaintFlow);
	
	void update(ComplaintFlowEntity complaintFlow);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
