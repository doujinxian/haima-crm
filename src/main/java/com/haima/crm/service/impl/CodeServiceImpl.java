package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.CodeDao;
import com.haima.crm.entity.CodeEntity;
import com.haima.crm.service.CodeService;



@Service("codeService")
public class CodeServiceImpl implements CodeService {
	@Autowired
	private CodeDao codeDao;
	
	@Override
	public CodeEntity queryObject(Long id){
		return codeDao.queryObject(id);
	}
	
	@Override
	public List<CodeEntity> queryList(Map<String, Object> map){
		return codeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return codeDao.queryTotal(map);
	}
	
	@Override
	public void save(CodeEntity code){
		codeDao.save(code);
	}
	
	@Override
	public void update(CodeEntity code){
		codeDao.update(code);
	}
	
	@Override
	public void delete(Long id){
		codeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		codeDao.deleteBatch(ids);
	}
	
}
