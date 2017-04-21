package com.haima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haima.crm.dto.CustomerCarDTO;
import com.haima.crm.entity.Car;
import com.haima.crm.entity.CustomerCar;
import com.haima.crm.service.CarColorService;
import com.haima.crm.service.CarModelService;
import com.haima.crm.service.CarSeriesService;
import com.haima.crm.service.CarService;
import com.haima.crm.service.CrmQueryService;
import com.haima.crm.service.CustomerCarService;
import com.haima.crm.service.CustomerService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;
import com.haima.crm.vo.CrmCustomerCarVo;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-04-15 21:40
 */

@Controller
@RequestMapping("crm")
public class CrmQueryController extends BaseController{
    @Autowired
    private CrmQueryService crmQueryService;
    @Autowired
    private CustomerCarService customerCarService;
    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CarColorService carColorService;
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private CarSeriesService carSeriesService;

    /**
     * 人车查询接口（新增投诉单点击vin码弹框，获取人车信息，也调用这个接口）
     */
    @ResponseBody
    @RequestMapping("/customer/car/list")
    public Result customerCarList(@RequestBody CrmCustomerCarVo crmCustomerCarVo) {
        // 查询列表数据
        List<CustomerCarDTO> customerCarList = crmQueryService.queryCustomerCarList(crmCustomerCarVo);
        int total = crmQueryService.queryCustomerCarTotal(crmCustomerCarVo);
        PageUtils pageUtil = new PageUtils(customerCarList, total, crmCustomerCarVo.getLimit(), crmCustomerCarVo.getPage());

        return Result.ok().put("page", pageUtil);
    }
    /**
     * 查询人车详情信息接口
     */
    @ResponseBody
    @RequestMapping("/customer/car/info/{customerCarId}")
	public Result info(@PathVariable("customerCarId") Long customerCarId){
    	//查询人车信息
    	CustomerCar customerCar = customerCarService.queryObject(customerCarId);
		if(customerCar!=null){
			//查询客户详情
			customerCar.setCustomer(customerService.queryObject(customerCar.getCustomerId()));
			//查询车颜色
			if(customerCar.getCarColorId()!=null){
				customerCar.setCarColor(carColorService.queryObject(Long.valueOf(customerCar.getCarColorId())));
			}
			if(customerCar.getCarId()!=null){
				//查询车信息
				Car car = carService.queryObject(customerCar.getCarId());
				if(car!=null){
					customerCar.setCar(car);
					//查询车型信息
					if(car.getCarModelId()!=null){
						customerCar.setCarModel(carModelService.queryObject(car.getCarModelId()));
					}
					//查询车系信息
					if(car.getCarSeriesId()!=null){
						customerCar.setCarSeries(carSeriesService.queryObject(car.getCarSeriesId()));
					}
				}
			}
		}
		
		return Result.ok().put("customerCar", customerCar);
	}
}
