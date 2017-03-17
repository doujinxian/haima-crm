package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.ComplaintForwardDao;
import com.haima.crm.entity.ComplaintForwardEntity;
import com.haima.crm.service.ComplaintForwardService;



@Service("complaintForwardService")
public class ComplaintForwardServiceImpl implements ComplaintForwardService {
	@Autowired
	private ComplaintForwardDao complaintForwardDao;
	
	@Override
	public ComplaintForwardEntity queryObject(Integer id){
		return complaintForwardDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintForwardEntity> queryList(Map<String, Object> map){
		return complaintForwardDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintForwardDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintForwardEntity complaintForward){
		complaintForwardDao.save(complaintForward);
	}
	
	@Override
	public void update(ComplaintForwardEntity complaintForward){
		complaintForwardDao.update(complaintForward);
	}
	
	@Override
	public void delete(Integer id){
		complaintForwardDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		complaintForwardDao.deleteBatch(ids);
	}
	
}
