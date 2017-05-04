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

import com.haima.crm.entity.CustomerCar;
import com.haima.crm.service.CustomerCarService;
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
@RequestMapping("ccms/customercar")
public class CustomerCarController extends BaseController{
	@Autowired
	private CustomerCarService customerCarService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Result list(Integer page, Integer limit, String vin){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		map.put("vin",vin);
		
		//查询列表数据
		List<CustomerCar> customerCarList = customerCarService.queryList(map);
		int total = customerCarService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(customerCarList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{customerId}")
	public Result info(@PathVariable("customerId") Long customerId){
		CustomerCar customerCar = customerCarService.queryObject(customerId);
		
		return Result.ok().put("customerCar", customerCar);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody CustomerCar customerCar){
		customerCarService.save(customerCar);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody CustomerCar customerCar){
		customerCarService.update(customerCar);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Long[] customerIds){
		customerCarService.deleteBatch(customerIds);
		
		return Result.ok();
	}
	
}
