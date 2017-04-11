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

import com.haima.crm.entity.Color;
import com.haima.crm.service.ColorService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
@Controller
@RequestMapping("color")
public class ColorController {
	@Autowired
	private ColorService colorService;
	
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
		List<Color> colorList = colorService.queryList(map);
		int total = colorService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(colorList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{colorId}")
	public Result info(@PathVariable("colorId") Integer colorId){
		Color color = colorService.queryObject(colorId);
		
		return Result.ok().put("color", color);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody Color color){
		colorService.save(color);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody Color color){
		colorService.update(color);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] colorIds){
		colorService.deleteBatch(colorIds);
		
		return Result.ok();
	}
	
}
