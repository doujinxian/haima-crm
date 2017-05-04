package com.haima.crm.dto;

import java.io.Serializable;

import com.haima.crm.vo.PageVo;

/**
 * 车辆信息查询参数
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:46
 */
public class CarQueryDto extends PageVo implements Serializable {
	private static final long serialVersionUID = -4083406074233019822L;
	// 车id
	private Integer carId;
	// 车系id
	private Integer carSeriesId;
	// 车系代码
	private String carSeriesCode;
	// 车型id
	private Integer carModelId;
	// 车型代码
	private String carModelCode;
	// 装备id
	private Integer carSetupId;
	// 车装备代码
	private String carSetupCode;
	// 颜色id
	private Integer colorId;
	// 颜色代码
	private String colorCode;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getCarSeriesId() {
		return carSeriesId;
	}

	public void setCarSeriesId(Integer carSeriesId) {
		this.carSeriesId = carSeriesId;
	}

	public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public Integer getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}

	public String getCarModelCode() {
		return carModelCode;
	}

	public void setCarModelCode(String carModelCode) {
		this.carModelCode = carModelCode;
	}

	public Integer getCarSetupId() {
		return carSetupId;
	}

	public void setCarSetupId(Integer carSetupId) {
		this.carSetupId = carSetupId;
	}

	public String getCarSetupCode() {
		return carSetupCode;
	}

	public void setCarSetupCode(String carSetupCode) {
		this.carSetupCode = carSetupCode;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

}
