package com.haima.crm.service;

import com.haima.crm.entity.ComplaintEntity;

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
	
	ComplaintEntity queryObject(Long id);
	
	List<ComplaintEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintEntity complaint);
	
	void update(ComplaintEntity complaint);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
