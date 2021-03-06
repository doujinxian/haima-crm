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

import springfox.documentation.annotations.ApiIgnore;

import com.haima.crm.entity.Customer;
import com.haima.crm.service.CustomerService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@ApiIgnore
@Controller
@RequestMapping("ccms/customer")
public class CustomerController extends BaseController{
	@Autowired
	private CustomerService customerService;
	
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
		List<Customer> customerList = customerService.queryList(map);
		int total = customerService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(customerList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{customerId}")
	public Result info(@PathVariable("customerId") Long customerId){
		Customer customer = customerService.queryObject(customerId);
		
		return Result.ok().put("customer", customer);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody Customer customer){
		customerService.save(customer);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody Customer customer){
		customerService.update(customer);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Long[] customerIds){
		customerService.deleteBatch(customerIds);
		
		return Result.ok();
	}
	
}
