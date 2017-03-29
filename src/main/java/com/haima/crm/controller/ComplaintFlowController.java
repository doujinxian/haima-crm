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
import com.haima.crm.entity.ComplaintFlow;
import com.haima.crm.service.ComplaintFlowService;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 记录投诉审核信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@Controller
@RequestMapping("complaintflow")
public class ComplaintFlowController {
	@Autowired
	private ComplaintFlowService complaintFlowService;
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
		List<ComplaintFlow> complaintFlowList = complaintFlowService.queryList(map);
		int total = complaintFlowService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(complaintFlowList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Integer id){
		ComplaintFlow complaintFlow = complaintFlowService.queryObject(id);
		
		return Result.ok().put("complaintFlow", complaintFlow);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody ComplaintFlow complaintFlow){
		Long complainId = complaintFlow.getComplainId();
		if(complainId==null){
			return Result.error("complainId不能为空");
		}
		//修改投诉单延迟状态为已申请
		Complaint complaint = new Complaint();
		complaint.setId(complainId);
		complaint.setComplainStatus(CommonConstants.COMPLAIN_STATUS_APPLY_CLOSE);
		complaint.setCallbackStatus(complaintFlow.getCallbackStatus());
		complaint.setCallbackTime(complaintFlow.getCallbackTime());
		complaintService.update(complaint);
		complaintFlowService.save(complaintFlow);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody ComplaintFlow complaintFlow){
		String complaintStatus = null;
		//申请通过，投诉单状态置为已关闭
		if(CommonConstants.CHECK_STATUS_AGREE.endsWith(complaintFlow.getCheckStatus())){
			complaintStatus = CommonConstants.COMPLAIN_STATUS_CLOSE;
		}
		//申请不通过，投诉单状态置为处理中
		else if(CommonConstants.CHECK_STATUS_DISAGREE.endsWith(complaintFlow.getCheckStatus())){
			complaintStatus = CommonConstants.COMPLAIN_STATUS_IN_DEAL;
		}
		if(complaintStatus!=null){
			Long complainId = complaintFlow.getComplainId();
			if(complainId==null){
				return Result.error("complainId不能为空");
			}
			//修改投诉单延迟状态为已批复
			Complaint complaint = new Complaint();
			complaint.setId(complainId);
			complaint.setComplainStatus(complaintStatus);
			complaintService.update(complaint);
		}
		
		complaintFlowService.update(complaintFlow);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintFlowService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
