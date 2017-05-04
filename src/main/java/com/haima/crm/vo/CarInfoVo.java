package com.haima.crm.vo;

import java.io.Serializable;

public class CarInfoVo implements Serializable {
	private static final long serialVersionUID = 2720504388524583411L;
	// 车id
	private transient Integer carId;
	// 车系id
	private Integer carSeriesId;
	// 车系代码
	private String carSeriesCode;
	// 车系名称
	private String carSeriesName;
	// 车型id
	private Integer carModelId;
	// 车型代码
	private String carModelCode;
	// 车型名称
	private String carModelName;
	// 装备id
	private Integer carSetupId;
	// 车装备代码
	private String carSetupCode;
	// 车装备名称
	private String carSetupName;
	// 颜色id
	private Integer colorId;
	// 颜色代码
	private String colorCode;
	// 颜色名称
	private String colorName;

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

	public String getCarSeriesName() {
		return carSeriesName;
	}

	public void setCarSeriesName(String carSeriesName) {
		this.carSeriesName = carSeriesName;
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

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
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

	public String getCarSetupName() {
		return carSetupName;
	}

	public void setCarSetupName(String carSetupName) {
		this.carSetupName = carSetupName;
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

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}
