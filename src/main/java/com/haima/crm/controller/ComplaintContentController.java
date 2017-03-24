package com.haima.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.haima.crm.entity.ComplaintContent;
import com.haima.crm.service.ComplaintContentService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 记录投诉内容信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@Controller
@RequestMapping("complaintcontent")
public class ComplaintContentController {
	@Autowired
	private ComplaintContentService complaintContentService;
	
	@RequestMapping("/complaintcontent.html")
	public String list(){
		return "complaintcontent/complaintcontent.html";
	}
	
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
		List<ComplaintContent> complaintContentList = complaintContentService.queryList(map);
		int total = complaintContentService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(complaintContentList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public Result info(@PathVariable("id") Integer id){
		ComplaintContent complaintContent = complaintContentService.queryObject(id);
		
		return Result.ok().put("complaintContent", complaintContent);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody ComplaintContent complaintContent){
		complaintContentService.save(complaintContent);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody ComplaintContent complaintContent){
		complaintContentService.update(complaintContent);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] ids){
		complaintContentService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
