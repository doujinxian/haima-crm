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

import com.haima.crm.entity.CarWorkorder;
import com.haima.crm.service.CarWorkorderService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;


/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
@Controller
@RequestMapping("carworkorder")
public class CarWorkorderController {
	@Autowired
	private CarWorkorderService carWorkorderService;
	
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
		List<CarWorkorder> carWorkorderList = carWorkorderService.queryList(map);
		int total = carWorkorderService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(carWorkorderList, total, limit, page);
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{vin}")
	public Result info(@PathVariable("vin") String vin){
		CarWorkorder carWorkorder = carWorkorderService.queryObject(vin);
		
		return Result.ok().put("carWorkorder", carWorkorder);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public Result save(@RequestBody CarWorkorder carWorkorder){
		carWorkorderService.save(carWorkorder);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody CarWorkorder carWorkorder){
		carWorkorderService.update(carWorkorder);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody String[] vins){
		carWorkorderService.deleteBatch(vins);
		
		return Result.ok();
	}
	
}
