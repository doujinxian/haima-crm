package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.ColorDao;
import com.haima.crm.entity.Color;
import com.haima.crm.service.ColorService;



@Service("colorService")
public class ColorServiceImpl implements ColorService {
	@Autowired
	private ColorDao colorDao;
	
	@Override
	public Color queryObject(Integer colorId){
		return colorDao.queryObject(colorId);
	}
	
	@Override
	public List<Color> queryList(Map<String, Object> map){
		return colorDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return colorDao.queryTotal(map);
	}
	
	@Override
	public void save(Color color){
		colorDao.save(color);
	}
	
	@Override
	public void update(Color color){
		colorDao.update(color);
	}
	
	@Override
	public void delete(Integer colorId){
		colorDao.delete(colorId);
	}
	
	@Override
	public void deleteBatch(Integer[] colorIds){
		colorDao.deleteBatch(colorIds);
	}
	
}
