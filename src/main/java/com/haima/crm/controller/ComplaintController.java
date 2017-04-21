package com.haima.crm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haima.crm.constants.CommonConstants;
import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintDealLog;
import com.haima.crm.entity.ComplaintDelay;
import com.haima.crm.entity.ComplaintFlow;
import com.haima.crm.service.ComplaintDealLogService;
import com.haima.crm.service.ComplaintDelayService;
import com.haima.crm.service.ComplaintFlowService;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;

/**
 * 记录投诉信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
@Controller
@RequestMapping("complaint")
public class ComplaintController extends BaseController{
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private ComplaintDelayService complaintDelayService;
	@Autowired
	private ComplaintFlowService complaintFlowService;
	@Autowired
	private ComplaintDealLogService complaintDealLogService;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Result list(@RequestBody Complaint complaint) {
		// 查询列表数据
		List<Complaint> complaintList = complaintService.queryList(complaint);
		int total = complaintService.queryTotal(complaint);

		PageUtils pageUtil = new PageUtils(complaintList, total, complaint.getLimit(), complaint.getPage());

		return Result.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable(value = "id") Long id) {
		Complaint complaint = complaintService.queryObject(id);
		if(complaint!=null){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("complainId", id);
			//查询延迟记录
			if(!CommonConstants.DELAY_STATUS_DEFAULT.equals(complaint.getDelayStatus())){
				List<ComplaintDelay> delays = complaintDelayService.queryList(map);
				if(delays.size()>0){
					complaint.setComplaintDelay(delays.get(delays.size()-1));
				}
			}
			//查询审核记录
			if(!CommonConstants.COMPLAIN_STATUS_DEFAULT.equals(complaint.getComplainStatus()) && !CommonConstants.COMPLAIN_STATUS_IN_DEAL.equals(complaint.getComplainStatus())){
				List<ComplaintFlow> flows = complaintFlowService.queryList(map);
				if(flows.size()>0){
					complaint.setComplaintFlow(flows.get(flows.size()-1));
				}
			}
			//查询处理记录
			complaint.setComplaintDealLogs(complaintDealLogService.queryList(map));
		}
		return Result.ok().put("complaint", complaint);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody Complaint complaint) {
		complaint.setComplainCode("C"+System.currentTimeMillis());
		complaint.setCreateBy(getUsername());
		complaintService.save(complaint);
		//新增或修改处理记录
		complaintDealLogService.saveOrUpdateList(complaint,complaint.getComplaintDealLogs());
		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody Complaint complaint, HttpServletRequest request) {
		List<ComplaintDealLog> dealLogs = complaint.getComplaintDealLogs();
		complaint.setUpdateBy(getUsername());
		if(dealLogs!=null && dealLogs.size()>0){
			//第一次添加处理记录，将投诉单未处理状态置为处理中
			if(CommonConstants.COMPLAIN_STATUS_DEFAULT.equals(complaint.getComplainStatus())){
				complaint.setComplainStatus(CommonConstants.COMPLAIN_STATUS_IN_DEAL);
				complaint.setResponseTime(new Date());
			}
			//新增或修改处理记录
			complaintDealLogService.saveOrUpdateList(complaint,complaint.getComplaintDealLogs());
		}
		complaintService.update(complaint);
		return Result.ok();
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Long[] ids) {
		complaintService.deleteBatch(ids);

		return Result.ok();
	}

}
