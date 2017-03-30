package com.haima.crm.service;

import com.haima.crm.entity.ComplaintDistribute;

import java.util.List;
import java.util.Map;

/**
 * 记录投诉分配信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-30 19:39:58
 */
public interface ComplaintDistributeService {
	
	ComplaintDistribute queryObject(Integer id);
	
	List<ComplaintDistribute> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ComplaintDistribute complaintDistribute);
	
	void update(ComplaintDistribute complaintDistribute);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
