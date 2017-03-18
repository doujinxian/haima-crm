package com.haima.crm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haima.crm.entity.Complaint;
import com.haima.crm.service.ComplaintService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

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
	public void test1(){
		/*Complaint c = new Complaint();
		c.setId(1L);
		c.setComplainCode("1212");
		complaintService.save(c);*/
		Complaint co =  complaintService.queryObject(1L);
		System.out.println(co.getComplainCode());
	}

}
