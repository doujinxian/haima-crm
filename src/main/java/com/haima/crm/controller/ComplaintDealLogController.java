package com.haima.crm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import com.haima.crm.constants.CommonConstants;
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
@Api(value =  "投诉单处理记录相关接口")
@RestController
@RequestMapping("ccms/complaintdeallog")
public class ComplaintDealLogController extends BaseController{
	@Autowired
	private ComplaintDealLogService complaintDealLogService;
	
	/**
	 * 列表
	 */
	@ApiOperation(value = "获取投诉单处理记录列表", notes = "根据传过来的id查询投诉单处理记录列表")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
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
	@ApiOperation(value = "获取投诉单处理记录详情", notes = "根据传过来的id查询投诉单处理记录详细信息")
	@ApiImplicitParam(name = "id", value = "投诉单处理记录id", required = true, dataType = "Integer")
	@ResponseBody
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public Result info(@PathVariable("id") Integer id){
		ComplaintDealLog complaintDealLog = complaintDealLogService.queryObject(id);
		
		return Result.ok().put("complaintDealLog", complaintDealLog);
	}
	
	/**
	 * 保存
	 */
	@ApiOperation(value = "新增处理记录", notes = "根据complaintDealLog对象新增处理记录")
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody ComplaintDealLog complaintDealLog){
		complaintDealLog.setCreateBy(getUsername());
		complaintDealLogService.save(complaintDealLog);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ApiOperation(value = "修改处理记录", notes = "根据complaintDealLog对象修改处理记录")
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("complainId", complaint.getId());
		List<ComplaintDealLog> complaintDealLogs = complaintDealLogService.queryList(map);
		return Result.ok().put("complaintDealLogs", complaintDealLogs);
	}
	
	/**
	 * 删除
	 */
	@ApiOperation(value = "删除处理记录", notes = "根据id删除处理记录")
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Result delete(@PathVariable("id") Integer id){
		ComplaintDealLog complaintDealLog = new ComplaintDealLog();
		complaintDealLog.setDelFlag(CommonConstants.DEL_FLAG_TRUE);
		complaintDealLog.setUpdateBy(getUsername());
		complaintDealLog.setId(id);
		complaintDealLogService.update(complaintDealLog);
		
		return Result.ok();
	}
	
}
