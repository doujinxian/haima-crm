package com.haima.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haima.crm.dao.ComplaintDao;
import com.haima.crm.dao.ComplaintDelayDao;
import com.haima.crm.dao.ComplaintFlowDao;
import com.haima.crm.dto.ComplaintDto;
import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintDelay;
import com.haima.crm.entity.ComplaintFlow;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.utils.DateConvertUtils;



@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	private ComplaintDao complaintDao;
	@Autowired
	private ComplaintDelayDao complaintDelayDao;
	@Autowired
	private ComplaintFlowDao complaintFlowDao;
	
	@Override
	public Complaint queryObject(Long id){
		return complaintDao.queryObject(id);
	}
	
	@Override
	public List<Complaint> queryList(Map<String, Object> map){
		return complaintDao.queryList(map);
	}
	
	@Override
	public List<Complaint> queryList(ComplaintDto complaintDto) {
		List<Complaint> complaints = complaintDao.queryList(complaintDto);
		if(complaints.size()==0){
			return complaints;
		}
		if(complaintDto.getIfSelectDelayInfo()!=null && complaintDto.getIfSelectDelayInfo()){
			List<Long> complaintIds = getComplaintsIds(complaints);
			ComplaintDelay params = new ComplaintDelay();
			params.setComplaintIds(complaintIds);
			List<ComplaintDelay> queryList = complaintDelayDao.queryList(params);
			for(ComplaintDelay cd :queryList){
				setComplaintDelay(cd,complaints);
			}
		}
		if(complaintDto.getIfSelectFlowInfo()!=null && complaintDto.getIfSelectFlowInfo()){
			List<Long> complaintIds = getComplaintsIds(complaints);
			ComplaintFlow params = new ComplaintFlow();
			params.setComplaintIds(complaintIds);
			List<ComplaintFlow> queryList = complaintFlowDao.queryList(params);
			for(ComplaintFlow cd :queryList){
				setComplaintFlow(cd,complaints);
			}
		}
		return complaints;
	}
	
	private void setComplaintFlow(ComplaintFlow cd, List<Complaint> complaints) {
		for(Complaint c : complaints){
			if(c.getId().equals(cd.getComplainId())){
				c.setComplaintFlow(cd);
				return;
			}
		}
	}

	private void setComplaintDelay(ComplaintDelay cd, List<Complaint> complaints) {
		for(Complaint c : complaints){
			if(c.getId().equals(cd.getComplainId())){
				c.setComplaintDelay(cd);
				return;
			}
		}
	}

	private List<Long> getComplaintsIds(List<Complaint> complaints) {
		List<Long> complaintIds = new ArrayList<Long>();
		for(Complaint c :complaints){
			complaintIds.add(c.getId());
		}
		return complaintIds;
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return complaintDao.queryTotal(map);
	}
	
	@Override
	public int queryTotal(ComplaintDto complaintDto) {
		return complaintDao.queryTotal(complaintDto);
	}
	
	@Override
	public void save(Complaint complaint){
		Date now = new Date();
		//TODO
		complaint.setComplainCode("C"+DateConvertUtils.formatDate(DateConvertUtils.DF_TO_DAY_2)+new Random().nextInt(9000)+1000);
		complaint.setCreateTime(now);
		complaint.setUpdateTime(now);
		complaint.setComplainTime(now);
		complaintDao.save(complaint);
	}
	
	@Override
	public void update(Complaint complaint){
		complaint.setUpdateTime(new Date());
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
