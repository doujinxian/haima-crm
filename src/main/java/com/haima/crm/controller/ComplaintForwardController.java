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
@Api(value =  "投诉单转发相关接口")
@Controller
@RequestMapping("ccms/complaintforward")
public class ComplaintForwardController extends BaseController{
	@Autowired
	private ComplaintForwardService complaintForwardService;
	@Autowired
	private ComplaintService complaintService;
	
	/**
	 * 列表
	 */
	@ApiOperation(value = "获取投诉单转发列表", notes = "根据传过来的id查询投诉单转发列表")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
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
	@ApiOperation(value = "根据传过来的id查询投诉单转发信息", notes = "根据传过来的id查询投诉单转发信息")
	@ResponseBody
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public Result info(@PathVariable("id") Integer id){
		ComplaintForward complaintForward = complaintForwardService.queryObject(id);
		
		return Result.ok().put("complaintForward", complaintForward);
	}
	
	/**
	 * 保存
	 */
	@ApiOperation(value = "新增投诉单转发信息", notes = "根据complaintForward对象新增投诉单转发信息")
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody ComplaintForward complaintForward){
		Long complainId = complaintForward.getComplainId();
		if(complainId==null){
			return Result.error("complainId不能为空");
		}
		//修改投诉单转发状态为已转发
		Complaint complaint = new Complaint();
		complaint.setId(complainId);
		complaint.setForwardStatus(CommonConstants.FORWARD_STATUS_HAS_FORWARD);
		complaint.setUpdateBy(getUsername());
		complaint.setTransTime(new Date());
		//转发后，将投诉单未处理状态置为处理中
		complaint.setComplainStatus(CommonConstants.COMPLAIN_STATUS_IN_DEAL);
		complaintService.update(complaint);
		
		
		complaintForward.setCreateBy(getUsername());
		complaintForward.setCreateTime(new Date());
		complaintForwardService.save(complaintForward);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ApiOperation(value = "修改投诉单转发信息", notes = "根据complaintForward对象修改投诉单转发信息")
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result update(@RequestBody ComplaintForward complaintForward){
		complaintForward.setUpdateBy(getUsername());
		complaintForwardService.update(complaintForward);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ApiIgnore
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintForwardService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
