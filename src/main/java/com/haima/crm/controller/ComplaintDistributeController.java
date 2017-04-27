package com.haima.crm.controller;

import java.util.Date;
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
import com.haima.crm.entity.ComplaintDistribute;
import com.haima.crm.service.ComplaintDistributeService;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 记录投诉分配信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-30 19:39:58
 */
@Controller
@RequestMapping("complaintdistribute")
public class ComplaintDistributeController extends BaseController{
	@Autowired
	private ComplaintDistributeService complaintDistributeService;
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
		List<ComplaintDistribute> complaintDistributeList = complaintDistributeService.queryList(map);
		int total = complaintDistributeService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(complaintDistributeList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Integer id){
		ComplaintDistribute complaintDistribute = complaintDistributeService.queryObject(id);
		
		return Result.ok().put("complaintDistribute", complaintDistribute);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/getByComplaintId/{complaintId}")
	public List<ComplaintDistribute> getByComplaintId(@PathVariable("complaintId") Integer complaintId){
		Map<String, Object> map = new HashMap<>();
		map.put("complaintId", complaintId);
		//查询列表数据
		List<ComplaintDistribute> complaintDistributeList = complaintDistributeService.queryList(map);
		return complaintDistributeList;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody ComplaintDistribute complaintDistribute){
		Long complainId = complaintDistribute.getComplainId();
		if(complainId==null){
			return Result.error("complainId不能为空");
		}
		//修改投诉单分配状态置为已分配
		Complaint complaint = new Complaint();
		complaint.setId(complainId);
		complaint.setDistributeStatus(CommonConstants.DISTRIBUTE_STATUS_DISTRIBUTED);
		//设置分配时间
		complaint.setResponseTime(new Date());
		complaint.setUpdateBy(getUsername());
		//设置投诉管理员
		complaint.setComplainAdmin(complaintDistribute.getHandleUser());
		complaintService.update(complaint);
		
		complaintDistribute.setCreateBy(getUsername());
		complaintDistributeService.save(complaintDistribute);
		
		return Result.ok();
	}
	
	/**
	 * 更换
	 */
	@ResponseBody
	@RequestMapping("/change")
	public Result change(@RequestBody ComplaintDistribute complaintDistribute){
		Long complainId = complaintDistribute.getComplainId();
		if(complainId==null){
			return Result.error("complainId不能为空");
		}
		//修改投诉单分配状态置为已更换
		Complaint complaint = new Complaint();
		complaint.setId(complainId);
		complaint.setDistributeStatus(CommonConstants.DISTRIBUTE_STATUS_CHANGED);
		complaint.setUpdateBy(getUsername());
		complaint.setComplainAdmin(complaintDistribute.getHandleUser());
		complaintService.update(complaint);
		//将之前的分配记录删除
		ComplaintDistribute temp = new ComplaintDistribute();
		temp.setId(complaintDistribute.getId());
		temp.setDelFlag(CommonConstants.DEL_FLAG_TRUE);
		temp.setUpdateBy(getUsername());
		complaintDistributeService.update(temp);
		//新增分配记录
		complaintDistribute.setId(null);
		complaintDistribute.setCreateBy(getUsername());
		complaintDistributeService.save(complaintDistribute);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody ComplaintDistribute complaintDistribute){
		complaintDistribute.setUpdateBy(getUsername());
		complaintDistributeService.update(complaintDistribute);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintDistributeService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
