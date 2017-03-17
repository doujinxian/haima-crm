package com.haima.crm.service;

import com.haima.crm.entity.CodeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
public interface CodeService {
	
	CodeEntity queryObject(Long id);
	
	List<CodeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CodeEntity code);
	
	void update(CodeEntity code);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
