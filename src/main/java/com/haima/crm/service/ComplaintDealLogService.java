package com.haima.crm.service;

import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintDealLog;

import java.util.List;
import java.util.Map;

/**
 * 投诉单处理记录
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
public interface ComplaintDealLogService {
	
	ComplaintDealLog queryObject(Integer id);
	
	List<ComplaintDealLog> queryList(Map<String, Object> map);
	
	List<ComplaintDealLog> queryList(ComplaintDealLog complaintDealLog);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintDealLog complaintDealLog);
	
	void update(ComplaintDealLog complaintDealLog);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveOrUpdateList(Complaint complaint, List<ComplaintDealLog> ccs);
}
