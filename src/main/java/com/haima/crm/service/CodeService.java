package com.haima.crm.service;

import com.haima.crm.entity.Code;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public interface CodeService {
	
	Code queryObject(Long id);
	
	List<Code> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Code code);
	
	void update(Code code);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
