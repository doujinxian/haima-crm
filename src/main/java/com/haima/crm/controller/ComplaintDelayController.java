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
import com.haima.crm.service.ComplaintDelayService;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 投诉延迟申请表
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@Controller
@RequestMapping("ccms/complaintdelay")
public class ComplaintDelayController extends BaseController{
	@Autowired
	private ComplaintDelayService complaintDelayService;
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
		Long complainId = complaintDelay.getComplainId();
		if(complainId==null){
			return Result.error("complainId不能为空");
		}
		//修改投诉单延迟状态为已申请
		Complaint complaint = new Complaint();
		complaint.setId(complainId);
		complaint.setDelayStatus(CommonConstants.DELAY_STATUS_APPLIED);
		complaint.setUpdateBy(getUsername());
		complaintService.update(complaint);
		
		complaintDelay.setCreateBy(getUsername());
		complaintDelayService.save(complaintDelay);
		
		return Result.ok();
	}
	
	/**
	 * 批复
	 */
	@ResponseBody
	@RequestMapping("/reply")
	public Result audit(@RequestBody ComplaintDelay complaintDelay){
		if(CommonConstants.REPLY_STATUS_AGREE.endsWith(complaintDelay.getReplyStatus()) || CommonConstants.REPLY_STATUS_DISAGREE.endsWith(complaintDelay.getReplyStatus())){
			Long complainId = complaintDelay.getComplainId();
			if(complainId==null){
				return Result.error("complainId不能为空");
			}
			//修改投诉单延迟状态为已批复
			Complaint complaint = new Complaint();
			complaint.setId(complainId);
			complaint.setDelayStatus(CommonConstants.DELAY_STATUS_AUDIT);
			complaint.setUpdateBy(getUsername());
			complaintService.update(complaint);
		}
		complaintDelay.setUpdateBy(getUsername());
		complaintDelayService.update(complaintDelay);
		
		return Result.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody ComplaintDelay complaintDelay){
		complaintDelay.setCreateBy(getUsername());
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
