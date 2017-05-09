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
@Api(value = "车系相关接口")
@Controller
@RequestMapping("ccms/carseries")
public class CarSeriesController extends BaseController {
	@Autowired
	private CarSeriesService carSeriesService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "获取车系列表", notes = "根据传过来的carSeries条件查询车系列表")
	@ApiImplicitParam(name = "carSeries", value = "投诉单查询参数carSeries", paramType = "query", dataType = "CarSeries")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list(CarSeries carSeries) {
		// 查询列表数据
		List<CarSeries> carSeriesList = carSeriesService.queryList(carSeries);
		int total = carSeriesService.queryTotal(carSeries);

		PageUtils pageUtil = new PageUtils(carSeriesList, total, carSeries.getLimit(), carSeries.getPage());

		return Result.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "获取车系详情", notes = "根据传过来的id查询车系详细信息")
	@ApiImplicitParam(name = "carSeriesId", value = "车系carSeriesId", required = true, dataType = "Integer")
	@ResponseBody
	@RequestMapping(value = "/info/{carSeriesId}", method = RequestMethod.GET)
	public Result info(@PathVariable("carSeriesId") Integer carSeriesId) {
		CarSeries carSeries = carSeriesService.queryObject(carSeriesId);

		return Result.ok().put("carSeries", carSeries);
	}

	/**
	 * 保存
	 */
	@ApiOperation(value = "新增车系", notes = "根据carSeries对象新增车系")
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody CarSeries carSeries) {
		carSeriesService.save(carSeries);

		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ApiOperation(value = "修改车系", notes = "根据carSeries对象修改车系")
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Result update(@RequestBody CarSeries carSeries) {
		carSeriesService.update(carSeries);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@ApiIgnore
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] carSeriesIds) {
		carSeriesService.deleteBatch(carSeriesIds);

		return Result.ok();
	}

}
