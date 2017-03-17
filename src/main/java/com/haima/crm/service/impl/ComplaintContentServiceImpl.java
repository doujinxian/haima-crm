package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.ComplaintContentDao;
import com.haima.crm.entity.ComplaintContentEntity;
import com.haima.crm.service.ComplaintContentService;



@Service("complaintContentService")
public class ComplaintContentServiceImpl implements ComplaintContentService {
	@Autowired
	private ComplaintContentDao complaintContentDao;
	
	@Override
	public ComplaintContentEntity queryObject(Integer id){
		return complaintContentDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintContentEntity> queryList(Map<String, Object> map){
		return complaintContentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintContentDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintContentEntity complaintContent){
		complaintContentDao.save(complaintContent);
	}
	
	@Override
	public void update(ComplaintContentEntity complaintContent){
		complaintContentDao.update(complaintContent);
	}
	
	@Override
	public void delete(Integer id){
		complaintContentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		complaintContentDao.deleteBatch(ids);
	}
	
}
