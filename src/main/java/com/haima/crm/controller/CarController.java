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

import springfox.documentation.annotations.ApiIgnore;

import com.haima.crm.entity.Car;
import com.haima.crm.service.CarService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:29
 */
@ApiIgnore
@Controller
@RequestMapping("ccms/car")
public class CarController extends BaseController{
	@Autowired
	private CarService carService;
	
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
		List<Car> carList = carService.queryList(map);
		int total = carService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(carList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{carId}")
	public Result info(@PathVariable("carId") Integer carId){
		Car car = carService.queryObject(carId);
		
		return Result.ok().put("car", car);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody Car car){
		carService.save(car);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody Car car){
		carService.update(car);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] carIds){
		carService.deleteBatch(carIds);
		
		return Result.ok();
	}
	
}
