package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.ComplaintFlowDao;
import com.haima.crm.entity.ComplaintFlowEntity;
import com.haima.crm.service.ComplaintFlowService;



@Service("complaintFlowService")
public class ComplaintFlowServiceImpl implements ComplaintFlowService {
	@Autowired
	private ComplaintFlowDao complaintFlowDao;
	
	@Override
	public ComplaintFlowEntity queryObject(Integer id){
		return complaintFlowDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintFlowEntity> queryList(Map<String, Object> map){
		return complaintFlowDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintFlowDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintFlowEntity complaintFlow){
		complaintFlowDao.save(complaintFlow);
	}
	
	@Override
	public void update(ComplaintFlowEntity complaintFlow){
		complaintFlowDao.update(complaintFlow);
	}
	
	@Override
	public void delete(Integer id){
		complaintFlowDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		complaintFlowDao.deleteBatch(ids);
	}
	
}
