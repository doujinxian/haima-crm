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

import com.haima.crm.entity.CarModel;
import com.haima.crm.service.CarModelService;
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
@RequestMapping("carmodel")
public class CarModelController {
	@Autowired
	private CarModelService carModelService;
	
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
		List<CarModel> carModelList = carModelService.queryList(map);
		int total = carModelService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(carModelList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{carModelId}")
	public Result info(@PathVariable("carModelId") Integer carModelId){
		CarModel carModel = carModelService.queryObject(carModelId);
		
		return Result.ok().put("carModel", carModel);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody CarModel carModel){
		carModelService.save(carModel);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody CarModel carModel){
		carModelService.update(carModel);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] carModelIds){
		carModelService.deleteBatch(carModelIds);
		
		return Result.ok();
	}
	
}
