package com.haima.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.haima.crm.entity.CustomerContact;
import com.haima.crm.service.CustomerContactService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@Controller
@RequestMapping("ccms/customercontact")
public class CustomerContactController extends BaseController{
	@Autowired
	private CustomerContactService customerContactService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Result list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<CustomerContact> customerContactList = customerContactService.queryList(map);
		int total = customerContactService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(customerContactList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{contactId}")
	public Result info(@PathVariable("contactId") Long contactId){
		CustomerContact customerContact = customerContactService.queryObject(contactId);
		
		return Result.ok().put("customerContact", customerContact);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody CustomerContact customerContact){
		customerContactService.save(customerContact);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody CustomerContact customerContact){
		customerContactService.update(customerContact);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Long[] contactIds){
		customerContactService.deleteBatch(contactIds);
		
		return Result.ok();
	}
	
}
