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

import com.haima.crm.entity.CarSeries;
import com.haima.crm.service.CarSeriesService;
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
@RequestMapping("ccms/carseries")
public class CarSeriesController extends BaseController{
	@Autowired
	private CarSeriesService carSeriesService;
	
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
		List<CarSeries> carSeriesList = carSeriesService.queryList(map);
		int total = carSeriesService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(carSeriesList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{carSeriesId}")
	public Result info(@PathVariable("carSeriesId") Integer carSeriesId){
		CarSeries carSeries = carSeriesService.queryObject(carSeriesId);
		
		return Result.ok().put("carSeries", carSeries);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody CarSeries carSeries){
		carSeriesService.save(carSeries);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody CarSeries carSeries){
		carSeriesService.update(carSeries);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] carSeriesIds){
		carSeriesService.deleteBatch(carSeriesIds);
		
		return Result.ok();
	}
	
}
