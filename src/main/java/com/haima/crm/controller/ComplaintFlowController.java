package com.haima.crm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

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
@Api(value =  "投诉单审核相关接口")
@Controller
@RequestMapping("ccms/complaintflow")
public class ComplaintFlowController extends BaseController{
	@Autowired
	private ComplaintFlowService complaintFlowService;
	@Autowired
	private ComplaintService complaintService;
	
	/**
	 * 列表
	 */
	@ApiOperation(value = "获取投诉单审核列表", notes = "根据传过来的id查询投诉单审核列表")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
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
	@ApiOperation(value = "根据传过来的id查询投诉单审核信息", notes = "根据传过来的id查询投诉单审核信息")
	@ResponseBody
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public Result info(@PathVariable("id") Integer id){
		ComplaintFlow complaintFlow = complaintFlowService.queryObject(id);
		
		return Result.ok().put("complaintFlow", complaintFlow);
	}
	
	/**
	 * 保存
	 */
	@ApiOperation(value = "新增投诉单审核信息", notes = "根据complaintFlow对象新增投诉单审核信息")
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
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
		complaint.setUpdateBy(getUsername());
		complaintService.update(complaint);
		
		complaintFlow.setCreateBy(getUsername());
		complaintFlowService.save(complaintFlow);
		
		return Result.ok();
	}
	
	/**
	 * 审核
	 */
	@ApiOperation(value = "审核投诉单审核信息", notes = "审核投诉单审核信息")
	@ResponseBody
	@RequestMapping(value = "/audit", method = RequestMethod.POST)
	public Result audit(@RequestBody ComplaintFlow complaintFlow){
		String complaintStatus = null;
		Complaint complaint = new Complaint();
		//审核通过，投诉单状态置为已关闭
		if(CommonConstants.CHECK_STATUS_AGREE.endsWith(complaintFlow.getCheckStatus())){
			complaintStatus = CommonConstants.COMPLAIN_STATUS_CLOSE;
			complaint.setCloseTime(new Date());
		}
		//审核不通过，投诉单状态置为处理中
		else if(CommonConstants.CHECK_STATUS_DISAGREE.endsWith(complaintFlow.getCheckStatus())){
			complaintStatus = CommonConstants.COMPLAIN_STATUS_IN_DEAL;
		}
		if(complaintStatus!=null){
			Long complainId = complaintFlow.getComplainId();
			if(complainId==null){
				return Result.error("complainId不能为空");
			}
			//修改投诉单延迟状态为已关闭/处理中
			complaint.setId(complainId);
			complaint.setComplainStatus(complaintStatus);
			complaint.setCreateBy(getUsername());
			complaintService.update(complaint);
		}
		complaintFlow.setUpdateBy(getUsername());
		complaintFlowService.update(complaintFlow);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ApiOperation(value = "修改投诉单审核信息", notes = "根据complaintFlow对象修改投诉单审核信息")
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result update(@RequestBody ComplaintFlow complaintFlow){
		complaintFlow.setUpdateBy(getUsername());
		complaintFlowService.update(complaintFlow);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ApiIgnore
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintFlowService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
