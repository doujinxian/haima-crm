package com.haima.crm.service;

import com.haima.crm.entity.Color;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public interface ColorService {
	
	Color queryObject(Integer colorId);
	
	List<Color> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Color color);
	
	void update(Color color);
	
	void delete(Integer colorId);
	
	void deleteBatch(Integer[] colorIds);
}
