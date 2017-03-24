package com.haima.crm.service;

import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintContent;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉内容信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
public interface ComplaintContentService {
	
	ComplaintContent queryObject(Integer id);
	
	List<ComplaintContent> queryList(Map<String, Object> map);
	
	List<ComplaintContent> queryList(ComplaintContent complaintContent);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintContent complaintContent);
	
	void update(ComplaintContent complaintContent);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void saveOrUpdateList(Complaint complaint, List<ComplaintContent> ccs);
}
