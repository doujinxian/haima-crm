package com.haima.crm.service;

import com.haima.crm.entity.Complaint;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
public interface ComplaintService {
	
	Complaint queryObject(Long id);
	
	List<Complaint> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Complaint complaint);
	
	void update(Complaint complaint);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);


}
