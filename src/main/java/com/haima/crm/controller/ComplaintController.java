package com.haima.crm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import com.haima.crm.constants.CommonConstants;
import com.haima.crm.dto.ComplaintDTO;
import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintDelay;
import com.haima.crm.entity.ComplaintFlow;
import com.haima.crm.service.ComplaintDealLogService;
import com.haima.crm.service.ComplaintDelayService;
import com.haima.crm.service.ComplaintFlowService;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.utils.DateConvertUtils;
import com.haima.crm.utils.ExcelGenerator;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;

/**
 * 记录投诉信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
@Api(description = "投诉单相关接口")
@RestController
@RequestMapping("ccms/complaint")
public class ComplaintController extends BaseController {
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private ComplaintDelayService complaintDelayService;
	@Autowired
	private ComplaintFlowService complaintFlowService;
	@Autowired
	private ComplaintDealLogService complaintDealLogService;

	/**
	 * 列表外部使用
	 */
	@ApiOperation(value = "获取投诉单列表", notes = "根据传过来的complaint条件查询投诉单列表")
	@ApiImplicitParam(name = "complaintDto", value = "投诉单查询参数complaintDto", required = true, dataType = "ComplaintDTO")
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Result list( ComplaintDTO complaintDto) {
		// 查询列表数据
		List<Complaint> complaintList = complaintService.queryList(complaintDto);
		int total = complaintService.queryTotal(complaintDto);

		PageUtils pageUtil = new PageUtils(complaintList, total, complaintDto.getLimit(), complaintDto.getPage());

		return Result.ok().put("page", pageUtil);
	}
	
	/**
	 * 列表
	 */
	@ApiIgnore
	@ResponseBody
	@RequestMapping(value = "/listcomplaint", method = RequestMethod.POST)
	public Result listcomplaint(@RequestBody ComplaintDTO complaintDto) {
		// 查询列表数据
		List<Complaint> complaintList = complaintService.queryList(complaintDto);
		int total = complaintService.queryTotal(complaintDto);

		PageUtils pageUtil = new PageUtils(complaintList, total, complaintDto.getLimit(), complaintDto.getPage());

		return Result.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "获取投诉单详情", notes = "根据传过来的id查询投诉单详细信息")
	@ApiImplicitParam(name = "id", value = "投诉单id", required = true, dataType = "Long")
	@ResponseBody
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public Result info(@PathVariable(value = "id") Long id) {
		Complaint complaint = complaintService.queryObject(id);
		if (complaint != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("complainId", id);
			// 查询延迟记录
			if (!CommonConstants.DELAY_STATUS_DEFAULT.equals(complaint.getDelayStatus())) {
				List<ComplaintDelay> delays = complaintDelayService.queryList(map);
				if (delays.size() > 0) {
					complaint.setComplaintDelay(delays.get(delays.size() - 1));
				}
			}
			// 查询审核记录
			if (!CommonConstants.COMPLAIN_STATUS_DEFAULT.equals(complaint.getComplainStatus()) && !CommonConstants.COMPLAIN_STATUS_IN_DEAL.equals(complaint.getComplainStatus())) {
				List<ComplaintFlow> flows = complaintFlowService.queryList(map);
				if (flows.size() > 0) {
					complaint.setComplaintFlow(flows.get(flows.size() - 1));
				}
			}
			// 查询处理记录
			complaint.setComplaintDealLogs(complaintDealLogService.queryList(map));
		}
		return Result.ok().put("complaint", complaint);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "新增投诉单", notes = "根据complaint对象新增投诉单")
	@ApiImplicitParam(name = "complaint", value = "投诉单详细实体complaint", required = true, dataType = "Complaint")
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody Complaint complaint) {
		complaint.setComplainCode("C" + System.currentTimeMillis());
		complaint.setCreateBy(getUsername());
		complaintService.save(complaint);
		// 新增或修改处理记录
		// complaintDealLogService.saveOrUpdateList(complaint,complaint.getComplaintDealLogs());
		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改投诉单", notes = "根据complaint对象更新投诉单")
	@ApiImplicitParam(name = "complaint", value = "投诉单详细实体complaint", required = true, dataType = "Complaint")
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result update(@RequestBody Complaint complaint, HttpServletRequest request) {
		complaint.setUpdateBy(getUsername());
		/*
		 * List<ComplaintDealLog> dealLogs = complaint.getComplaintDealLogs();
		 * if(dealLogs!=null && dealLogs.size()>0){ //新增或修改处理记录
		 * complaintDealLogService
		 * .saveOrUpdateList(complaint,complaint.getComplaintDealLogs()); }
		 */
		complaintService.update(complaint);
		return Result.ok();
	}

	/**
	 * 导出excel
	 */
	@ApiOperation(value = "导出投诉单excel", notes = "根据complaint对象导出投诉单")
	@ApiImplicitParam(name = "complaintDto", value = "投诉单查询参数complaintDto", required = true, dataType = "ComplaintDTO")
	@RequestMapping(value = "/export", method = RequestMethod.POST)
	public void exportExcel(ComplaintDTO complaintDto, HttpServletRequest request, HttpServletResponse response) {
		int maxExportSize = 100000;
		/*
		 * int total = complaintService.queryTotal(complaint);
		 * if(total>maxExportSize){ return
		 * Result.error("一次只能导出"+maxExportSize+"条数据"); }
		 */
		try {
			complaintDto.setPage(1);
			complaintDto.setLimit(maxExportSize);
			List<Complaint> complaintList = complaintService.queryList(complaintDto);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("complaintList", complaintList);
			ExcelGenerator.exportExcelAuroWrap(request, response, "complaint_list.xls", "投诉单列表" + DateConvertUtils.formatDate(DateConvertUtils.DF_TO_DAY), map);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 */
	@ApiIgnore
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Result delete(@RequestBody Long[] ids) {
		complaintService.deleteBatch(ids);

		return Result.ok();
	}

}
