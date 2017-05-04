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

import com.haima.crm.dto.CarQueryDto;
import com.haima.crm.dto.CustomerCarDto;
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
import com.haima.crm.vo.CarInfoVo;
import com.haima.crm.vo.CrmCustomerCarVo;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-04-15 21:40
 */
@Api(value = "车辆信息关联查询接口")
@Controller
@RequestMapping("ccms/crm")
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
    
    @ApiOperation(value = "车辆信息关联查询", notes = "根据传过来的carQueryDTO条件查询车辆信息列表")
	@ApiImplicitParam(name = "carQueryDTO", value = "投诉单查询参数carQueryDTO", dataType = "CarQueryDto")
    @ResponseBody
    @RequestMapping(value = "/car/list", method = RequestMethod.GET)
    public Result carList(CarQueryDto carQueryDTO) {
        // 查询列表数据
        List<CarInfoVo> customerCarList = crmQueryService.queryCarInfoList(carQueryDTO);
        int total = crmQueryService.queryCarInfoListTotal(carQueryDTO);
        PageUtils pageUtil = new PageUtils(customerCarList, total, carQueryDTO.getLimit(), carQueryDTO.getPage());

        return Result.ok().put("page", pageUtil);
    }
    
    /**
     * 人车查询接口（新增投诉单点击vin码弹框，获取人车信息，也调用这个接口）
     */
    @ApiIgnore
    @ResponseBody
    @RequestMapping("/customer/car/list")
    public Result customerCarList(@RequestBody CrmCustomerCarVo crmCustomerCarVo) {
        // 查询列表数据
        List<CustomerCarDto> customerCarList = crmQueryService.queryCustomerCarList(crmCustomerCarVo);
        int total = crmQueryService.queryCustomerCarTotal(crmCustomerCarVo);
        PageUtils pageUtil = new PageUtils(customerCarList, total, crmCustomerCarVo.getLimit(), crmCustomerCarVo.getPage());

        return Result.ok().put("page", pageUtil);
    }
    
    /**
     * 查询人车详情信息接口
     */
    @ApiIgnore
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
