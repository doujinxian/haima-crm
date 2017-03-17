package com.haima.crm.service;

import com.haima.crm.entity.ComplaintContentEntity;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉内容信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public interface ComplaintContentService {
	
	ComplaintContentEntity queryObject(Integer id);
	
	List<ComplaintContentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintContentEntity complaintContent);
	
	void update(ComplaintContentEntity complaintContent);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
