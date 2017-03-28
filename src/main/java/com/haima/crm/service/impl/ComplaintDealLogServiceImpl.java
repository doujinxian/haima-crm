package com.haima.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haima.crm.dao.ComplaintDealLogDao;
import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintDealLog;
import com.haima.crm.service.ComplaintDealLogService;



@Service("complaintDealLogServiceImpl")
public class ComplaintDealLogServiceImpl implements ComplaintDealLogService {
	@Autowired
	private ComplaintDealLogDao complaintDealLogDao;
	
	@Override
	public ComplaintDealLog queryObject(Integer id){
		return complaintDealLogDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintDealLog> queryList(Map<String, Object> map){
		return complaintDealLogDao.queryList(map);
	}
	
	@Override
	public List<ComplaintDealLog> queryList(ComplaintDealLog complaintDealLog) {
		return complaintDealLogDao.queryList(complaintDealLog);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintDealLogDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintDealLog complaintDealLog){
		complaintDealLogDao.save(complaintDealLog);
	}
	
	@Override
	public void update(ComplaintDealLog complaintDealLog){
		complaintDealLogDao.update(complaintDealLog);
	}
	
	@Override
	public void delete(Integer id){
		complaintDealLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		complaintDealLogDao.deleteBatch(ids);
	}
	@Override
	public void saveOrUpdateList(Complaint complaint, List<ComplaintDealLog> ccs) {
		Date now = new Date();
		if(ccs!=null && ccs.size()>0){
			for(ComplaintDealLog cc:ccs){
				if(cc.getId()==null){
					cc.setCreateTime(now);
					cc.setUpdateTime(now);
					cc.setComplainCode(complaint.getComplainCode());
					save(cc);
				}else{
					cc.setUpdateTime(now);
					cc.setComplainCode(complaint.getComplainCode());
					update(cc);
				}
			}
		}
	}
}
