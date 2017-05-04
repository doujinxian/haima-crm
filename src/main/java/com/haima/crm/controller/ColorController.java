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
@Api(description = "车身颜色相关接口")
@Controller
@RequestMapping("ccms/color")
public class ColorController extends BaseController {
	@Autowired
	private ColorService colorService;

	/**
	 * 列表
	 */
	@ApiOperation(value = "获取车身颜色列表", notes = "根据传过来的color条件查询车身颜色列表")
	@ApiImplicitParam(name = "color", value = "投诉单查询参数color", required = true, dataType = "Color")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list(Color color) {
		// 查询列表数据
		List<Color> colorList = colorService.queryList(color);
		int total = colorService.queryTotal(color);

		PageUtils pageUtil = new PageUtils(colorList, total, color.getLimit(), color.getPage());

		return Result.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@ApiOperation(value = "获取车身颜色详情", notes = "根据传过来的id查询车身颜色详细信息")
	@ApiImplicitParam(name = "carModelId", value = "车身颜色carModelId", required = true, dataType = "Integer")
	@ResponseBody
	@RequestMapping(value = "/info/{colorId}", method = RequestMethod.GET)
	public Result info(@PathVariable("colorId") Integer colorId) {
		Color color = colorService.queryObject(colorId);

		return Result.ok().put("color", color);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result save(@RequestBody Color color) {
		colorService.save(color);

		return Result.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result update(@RequestBody Color color) {
		colorService.update(color);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@ApiIgnore
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody Integer[] colorIds) {
		colorService.deleteBatch(colorIds);

		return Result.ok();
	}

}
