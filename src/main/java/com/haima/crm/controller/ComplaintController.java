package com.haima.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haima.crm.constants.CommonConstants;
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
		//complaintDealLogService.saveOrUpdateList(complaint,complaint.getComplaintDealLogs());
		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody Complaint complaint, HttpServletRequest request) {
		complaint.setUpdateBy(getUsername());
		/*List<ComplaintDealLog> dealLogs = complaint.getComplaintDealLogs();
		if(dealLogs!=null && dealLogs.size()>0){
			//新增或修改处理记录
			complaintDealLogService.saveOrUpdateList(complaint,complaint.getComplaintDealLogs());
		}*/
		complaintService.update(complaint);
		return Result.ok();
	}
	
	/**
     * 导出excel
     */
    @RequestMapping(value="/export")
    public void exportExcel(Complaint complaint,HttpServletRequest request,HttpServletResponse response) {
    	int maxExportSize = 100000;
    	/*int total = complaintService.queryTotal(complaint);
    	if(total>maxExportSize){
    		return Result.error("一次只能导出"+maxExportSize+"条数据");
    	}*/
    	try {
			complaint.setPage(1);
			complaint.setLimit(maxExportSize);
			List<Complaint> complaintList = complaintService.queryList(complaint);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("complaintList", complaintList);
			ExcelGenerator.exportExcelAuroWrap(request, response, "complaint_list.xls", "投诉单列表"+DateConvertUtils.formatDate(DateConvertUtils.DF_TO_DAY), map);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
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
