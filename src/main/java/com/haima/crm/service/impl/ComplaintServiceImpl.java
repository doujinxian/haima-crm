package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.ComplaintDao;
import com.haima.crm.entity.ComplaintEntity;
import com.haima.crm.service.ComplaintService;



@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	private ComplaintDao complaintDao;
	
	@Override
	public ComplaintEntity queryObject(Long id){
		return complaintDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintEntity> queryList(Map<String, Object> map){
		return complaintDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintEntity complaint){
		complaintDao.save(complaint);
	}
	
	@Override
	public void update(ComplaintEntity complaint){
		complaintDao.update(complaint);
	}
	
	@Override
	public void delete(Long id){
		complaintDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		complaintDao.deleteBatch(ids);
	}
	
}
