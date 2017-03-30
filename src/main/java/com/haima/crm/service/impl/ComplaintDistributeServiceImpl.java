package com.haima.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haima.crm.dao.ComplaintDistributeDao;
import com.haima.crm.entity.ComplaintDistribute;
import com.haima.crm.service.ComplaintDistributeService;



@Service("complaintDistributeService")
public class ComplaintDistributeServiceImpl implements ComplaintDistributeService {
	@Autowired
	private ComplaintDistributeDao complaintDistributeDao;
	
	@Override
	public ComplaintDistribute queryObject(Integer id){
		return complaintDistributeDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintDistribute> queryList(Map<String, Object> map){
		return complaintDistributeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintDistributeDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintDistribute complaintDistribute){
		Date now = new Date();
		complaintDistribute.setCreateTime(now);
		complaintDistribute.setHandleDate(now);
		complaintDistributeDao.save(complaintDistribute);
	}
	
	@Override
	public void update(ComplaintDistribute complaintDistribute){
		complaintDistributeDao.update(complaintDistribute);
	}
	
	@Override
	public void delete(Integer id){
		complaintDistributeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		complaintDistributeDao.deleteBatch(ids);
	}
	
}
