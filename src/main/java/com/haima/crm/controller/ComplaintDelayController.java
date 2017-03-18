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

import com.haima.crm.entity.ComplaintDelay;
import com.haima.crm.service.ComplaintDelayService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 投诉延迟申请表
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
@Controller
@RequestMapping("complaintdelay")
public class ComplaintDelayController {
	@Autowired
	private ComplaintDelayService complaintDelayService;
	
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
		List<ComplaintDelay> complaintDelayList = complaintDelayService.queryList(map);
		int total = complaintDelayService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(complaintDelayList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Integer id){
		ComplaintDelay complaintDelay = complaintDelayService.queryObject(id);
		
		return Result.ok().put("complaintDelay", complaintDelay);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody ComplaintDelay complaintDelay){
		complaintDelayService.save(complaintDelay);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody ComplaintDelay complaintDelay){
		complaintDelayService.update(complaintDelay);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintDelayService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
