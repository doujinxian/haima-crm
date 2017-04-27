package com.haima.crm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintDealLog;
import com.haima.crm.service.ComplaintDealLogService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 投诉单处理记录
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@Controller
@RequestMapping("complaintdeallog")
public class ComplaintDealLogController extends BaseController{
	@Autowired
	private ComplaintDealLogService complaintDealLogService;
	
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
		List<ComplaintDealLog> complaintDealLogList = complaintDealLogService.queryList(map);
		int total = complaintDealLogService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(complaintDealLogList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Integer id){
		ComplaintDealLog complaintDealLog = complaintDealLogService.queryObject(id);
		
		return Result.ok().put("complaintDealLog", complaintDealLog);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody ComplaintDealLog complaintDealLog){
		complaintDealLog.setCreateBy(getUsername());
		complaintDealLogService.save(complaintDealLog);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody Complaint complaint, HttpServletRequest request) {
		complaint.setUpdateBy(getUsername());
		List<ComplaintDealLog> dealLogs = complaint.getComplaintDealLogs();
		if(dealLogs!=null && dealLogs.size()>0){
			//新增或修改处理记录
			Date now = new Date();
			for(ComplaintDealLog cc:dealLogs){
				if(StringUtils.isBlank(cc.getContent())){
					return Result.error("内容不能为空！");
				}
				if(cc.getId()==null){
					cc.setCreateTime(now);
					cc.setUpdateTime(now);
					cc.setComplainId(complaint.getId());
					cc.setCreateBy(getUsername());
					complaintDealLogService.save(cc);
				}else{
					cc.setUpdateTime(now);
					cc.setComplainId(complaint.getId());
					cc.setUpdateBy(getUsername());
					complaintDealLogService.update(cc);
				}
			}
		}
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintDealLogService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
