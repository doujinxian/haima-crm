package com.haima.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haima.crm.constants.CommonConstants;
import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintDelay;
import com.haima.crm.entity.ComplaintForward;
import com.haima.crm.service.ComplaintForwardService;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 记录投诉转发信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-30 19:39:58
 */
@Controller
@RequestMapping("complaintforward")
public class ComplaintForwardController {
	@Autowired
	private ComplaintForwardService complaintForwardService;
	@Autowired
	private ComplaintService complaintService;
	
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
		List<ComplaintForward> complaintForwardList = complaintForwardService.queryList(map);
		int total = complaintForwardService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(complaintForwardList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Integer id){
		ComplaintForward complaintForward = complaintForwardService.queryObject(id);
		
		return Result.ok().put("complaintForward", complaintForward);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody ComplaintForward complaintForward){
		Long complainId = complaintForward.getComplainId();
		if(complainId==null){
			return Result.error("complainId不能为空");
		}
		//修改投诉单转发状态为已转发
		Complaint complaint = new Complaint();
		complaint.setId(complainId);
		complaint.setForwardStatus(CommonConstants.FORWARD_STATUS_HAS_FORWARD);
		complaintService.update(complaint);
		
		complaintForwardService.save(complaintForward);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody ComplaintForward complaintForward){
		complaintForwardService.update(complaintForward);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintForwardService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
