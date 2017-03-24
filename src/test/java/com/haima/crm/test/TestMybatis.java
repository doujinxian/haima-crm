package com.haima.crm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haima.crm.entity.Complaint;
import com.haima.crm.service.ComplaintService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TestMybatis {
	
	private ComplaintService complaintService;
	
	public ComplaintService getComplaintService() {
		return complaintService;
	}

	@Autowired
	public void setComplaintService(ComplaintService complaintService) {
		this.complaintService = complaintService;
	}

	@Test
	public void save(){
		Complaint c = new Complaint();
		c.setComplainCode("wefwef");
		c.setBuyDate(new Date());
		complaintService.save(c);
	}
	
	@Test
	public void queryObject(){
		Complaint co =  complaintService.queryObject(1100L);
		System.out.println(co.getComplainCode());
	}
	
	
	@Test
	public void queryList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1L);
		List<Complaint> co =  complaintService.queryList(map);
		System.out.println(co.get(0).getComplainCode());
	}
	
	@Test
	public void queryTotal(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1L);
		int count = complaintService.queryTotal(map);
		System.out.println(count);
	}
	
	@Test
	public void update(){
		Complaint c = new Complaint();
		c.setId(1100L);
		c.setComplainCode("wefwef");
		c.setBuyDate(new Date());
		complaintService.update(c);
	}
}
