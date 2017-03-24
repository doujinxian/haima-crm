package com.haima.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haima.crm.constants.CommonConstants;
import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintContent;
import com.haima.crm.entity.CustomerContact;
import com.haima.crm.service.ComplaintContentService;
import com.haima.crm.service.ComplaintService;
import com.haima.crm.service.CustomerContactService;
import com.haima.crm.utils.DateConvertUtils;
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
public class ComplaintController {
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private ComplaintContentService complaintContentService;

	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateConvertUtils.FORMAT_DATE_19);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/

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
			ComplaintContent cc = new ComplaintContent();
			cc.setComplainCode(complaint.getComplainCode());
			complaint.setComplaintContents(complaintContentService.queryList(cc));
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
		complaintService.save(complaint);
		//新增或修改投诉内容
		complaintContentService.saveOrUpdateList(complaint,complaint.getComplaintContents());
		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody Complaint complaint) {
		complaintService.update(complaint);
		//新增或修改投诉内容
		complaintContentService.saveOrUpdateList(complaint,complaint.getComplaintContents());
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
