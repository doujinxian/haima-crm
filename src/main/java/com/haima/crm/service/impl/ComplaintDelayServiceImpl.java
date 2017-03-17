package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.ComplaintDelayDao;
import com.haima.crm.entity.ComplaintDelayEntity;
import com.haima.crm.service.ComplaintDelayService;



@Service("complaintDelayService")
public class ComplaintDelayServiceImpl implements ComplaintDelayService {
	@Autowired
	private ComplaintDelayDao complaintDelayDao;
	
	@Override
	public ComplaintDelayEntity queryObject(Integer id){
		return complaintDelayDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintDelayEntity> queryList(Map<String, Object> map){
		return complaintDelayDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintDelayDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintDelayEntity complaintDelay){
		complaintDelayDao.save(complaintDelay);
	}
	
	@Override
	public void update(ComplaintDelayEntity complaintDelay){
		complaintDelayDao.update(complaintDelay);
	}
	
	@Override
	public void delete(Integer id){
		complaintDelayDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		complaintDelayDao.deleteBatch(ids);
	}
	
}
