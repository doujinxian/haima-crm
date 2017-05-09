package com.haima.crm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

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
@Api(value = "车型相关接口")
@Controller
@RequestMapping("ccms/carmodel")
public class CarModelController extends BaseController{
	@Autowired
	private CarModelService carModelService;
	
	/**
	 * 列表
	 */
	@ApiOperation(value = "获取车型列表", notes = "根据传过来的carModel条件查询车型列表")
	@ApiImplicitParam(name = "carModel", value = "投诉单查询参数carModel", paramType = "query", dataType = "CarModel")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list(CarModel carModel){
		//查询列表数据
		List<CarModel> carModelList = carModelService.queryList(carModel);
		int total = carModelService.queryTotal(carModel);
		
		PageUtils pageUtil = new PageUtils(carModelList, total, carModel.getLimit(), carModel.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ApiOperation(value = "获取车型详情", notes = "根据传过来的id查询车型详细信息")
	@ApiImplicitParam(name = "carModelId", value = "车型carModelId", required = true, dataType = "Integer")
	@ResponseBody
	@RequestMapping(value = "/info/{carModelId}", method = RequestMethod.GET)
	public Result info(@PathVariable("carModelId") Integer carModelId){
		CarModel carModel = carModelService.queryObject(carModelId);
		
		return Result.ok().put("carModel", carModel);
	}
	
	/**
	 * 保存
	 */
	@ApiOperation(value = "新增车型", notes = "根据carModel对象新增车型")
	@ResponseBody
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public Result save(@RequestBody CarModel carModel){
		carModelService.save(carModel);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@ApiOperation(value = "修改车型", notes = "根据carModel对象修改车型")
	@ResponseBody
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public Result update(@RequestBody CarModel carModel){
		carModelService.update(carModel);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@ApiIgnore
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] carModelIds){
		carModelService.deleteBatch(carModelIds);
		
		return Result.ok();
	}
	
}
