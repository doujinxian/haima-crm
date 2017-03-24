package com.haima.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haima.crm.constants.CommonConstants;
import com.haima.crm.dao.ComplaintContentDao;
import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintContent;
import com.haima.crm.service.ComplaintContentService;



@Service("complaintContentService")
public class ComplaintContentServiceImpl implements ComplaintContentService {
	@Autowired
	private ComplaintContentDao complaintContentDao;
	
	@Override
	public ComplaintContent queryObject(Integer id){
		return complaintContentDao.queryObject(id);
	}
	
	@Override
	public List<ComplaintContent> queryList(Map<String, Object> map){
		return complaintContentDao.queryList(map);
	}
	
	@Override
	public List<ComplaintContent> queryList(ComplaintContent complaintContent) {
		return complaintContentDao.queryList(complaintContent);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintContentDao.queryTotal(map);
	}
	
	@Override
	public void save(ComplaintContent complaintContent){
		complaintContentDao.save(complaintContent);
	}
	
	@Override
	public void update(ComplaintContent complaintContent){
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
	@Override
	public void saveOrUpdateList(Complaint complaint, List<ComplaintContent> ccs) {
		Date now = new Date();
		if(ccs!=null && ccs.size()>0){
			for(ComplaintContent cc:ccs){
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
