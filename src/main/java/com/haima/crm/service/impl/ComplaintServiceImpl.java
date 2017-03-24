package com.haima.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.haima.crm.dao.ComplaintDao;
import com.haima.crm.entity.Complaint;
import com.haima.crm.service.ComplaintService;



@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	private ComplaintDao complaintDao;
	
	@Override
	public Complaint queryObject(Long id){
		return complaintDao.queryObject(id);
	}
	
	@Override
	public List<Complaint> queryList(Map<String, Object> map){
		return complaintDao.queryList(map);
	}
	
	@Override
	public List<Complaint> queryList(Complaint complaint) {
		return complaintDao.queryList(complaint);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintDao.queryTotal(map);
	}
	
	@Override
	public int queryTotal(Complaint complaint) {
		return complaintDao.queryTotal(complaint);
	}
	
	@Override
	public void save(Complaint complaint){
		complaintDao.save(complaint);
	}
	
	@Override
	public void update(Complaint complaint){
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
