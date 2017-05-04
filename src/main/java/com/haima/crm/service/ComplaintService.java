package com.haima.crm.service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dto.ComplaintDTO;
import com.haima.crm.entity.Complaint;

/**
 * 记录投诉信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:46
 */
public interface ComplaintService {
	
	Complaint queryObject(Long id);
	
	List<Complaint> queryList(Map<String, Object> map);
	
	List<Complaint> queryList(ComplaintDTO complaintDto);
	
	int queryTotal(Map<String, Object> map);
	
	int queryTotal(ComplaintDTO complaintDto);
	
	void save(Complaint complaint);
	
	void update(Complaint complaint);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
