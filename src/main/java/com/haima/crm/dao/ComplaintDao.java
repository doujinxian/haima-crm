package com.haima.crm.dao;

import com.haima.crm.dto.ComplaintDTO;
import com.haima.crm.entity.Complaint;

/**
 * 记录投诉信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:46
 */
public interface ComplaintDao extends BaseDao<Complaint> {
	
	int queryTotal(ComplaintDTO t);
	
}
