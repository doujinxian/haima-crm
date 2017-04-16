package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;

import com.haima.crm.vo.CarModelVo;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public class CarModel extends CarModelVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//车系id
	private Integer carModelId;
	//车型id
	private Integer carSeriesId;
	//车型代码
	private String carModelCode;
	//车型名称
	private String carModelName;
	//轴距
	private String axesSpace;
	//后轮距
	private String backringSpace;
	//后悬挂系统
	private String backSuspend;
	//行李箱容积
	private String baggageVolume;
	//长宽高
	private String bodySize;
	//变速器型号
	private String boxType;
	//刹车系统
	private String brakeSystem;
	//驱动形式
	private String driveType;
	//发动机型号
	private String engineType;
	//环保装置
	private String environmentSetup;
	//前轮距
	private String frontringSpace;
	//前悬挂系统
	private String frontSuspend;
	//内饰风格
	private String insideDeckStyle;
	//业务是否启用：0未1是
	private Integer businessEnable;
	//是否删除：0未1是
	private String delFlg;
	//创建者
	private String creator;
	//创建时间
	private Date createTime;
	//修改者
	private String modifier;
	//修改时间
	private Date modifyTime;

	/**
	 * 设置：车系id
	 */
	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}
	/**
	 * 获取：车系id
	 */
	public Integer getCarModelId() {
		return carModelId;
	}
	/**
	 * 设置：车型id
	 */
	public void setCarSeriesId(Integer carSeriesId) {
		this.carSeriesId = carSeriesId;
	}
	/**
	 * 获取：车型id
	 */
	public Integer getCarSeriesId() {
		return carSeriesId;
	}
	/**
	 * 设置：车型代码
	 */
	public void setCarModelCode(String carModelCode) {
		this.carModelCode = carModelCode;
	}
	/**
	 * 获取：车型代码
	 */
	public String getCarModelCode() {
		return carModelCode;
	}
	/**
	 * 设置：车型名称
	 */
	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}
	/**
	 * 获取：车型名称
	 */
	public String getCarModelName() {
		return carModelName;
	}
	/**
	 * 设置：轴距
	 */
	public void setAxesSpace(String axesSpace) {
		this.axesSpace = axesSpace;
	}
	/**
	 * 获取：轴距
	 */
	public String getAxesSpace() {
		return axesSpace;
	}
	/**
	 * 设置：后轮距
	 */
	public void setBackringSpace(String backringSpace) {
		this.backringSpace = backringSpace;
	}
	/**
	 * 获取：后轮距
	 */
	public String getBackringSpace() {
		return backringSpace;
	}
	/**
	 * 设置：后悬挂系统
	 */
	public void setBackSuspend(String backSuspend) {
		this.backSuspend = backSuspend;
	}
	/**
	 * 获取：后悬挂系统
	 */
	public String getBackSuspend() {
		return backSuspend;
	}
	/**
	 * 设置：行李箱容积
	 */
	public void setBaggageVolume(String baggageVolume) {
		this.baggageVolume = baggageVolume;
	}
	/**
	 * 获取：行李箱容积
	 */
	public String getBaggageVolume() {
		return baggageVolume;
	}
	/**
	 * 设置：长宽高
	 */
	public void setBodySize(String bodySize) {
		this.bodySize = bodySize;
	}
	/**
	 * 获取：长宽高
	 */
	public String getBodySize() {
		return bodySize;
	}
	/**
	 * 设置：变速器型号
	 */
	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}
	/**
	 * 获取：变速器型号
	 */
	public String getBoxType() {
		return boxType;
	}
	/**
	 * 设置：刹车系统
	 */
	public void setBrakeSystem(String brakeSystem) {
		this.brakeSystem = brakeSystem;
	}
	/**
	 * 获取：刹车系统
	 */
	public String getBrakeSystem() {
		return brakeSystem;
	}
	/**
	 * 设置：驱动形式
	 */
	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}
	/**
	 * 获取：驱动形式
	 */
	public String getDriveType() {
		return driveType;
	}
	/**
	 * 设置：发动机型号
	 */
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	/**
	 * 获取：发动机型号
	 */
	public String getEngineType() {
		return engineType;
	}
	/**
	 * 设置：环保装置
	 */
	public void setEnvironmentSetup(String environmentSetup) {
		this.environmentSetup = environmentSetup;
	}
	/**
	 * 获取：环保装置
	 */
	public String getEnvironmentSetup() {
		return environmentSetup;
	}
	/**
	 * 设置：前轮距
	 */
	public void setFrontringSpace(String frontringSpace) {
		this.frontringSpace = frontringSpace;
	}
	/**
	 * 获取：前轮距
	 */
	public String getFrontringSpace() {
		return frontringSpace;
	}
	/**
	 * 设置：前悬挂系统
	 */
	public void setFrontSuspend(String frontSuspend) {
		this.frontSuspend = frontSuspend;
	}
	/**
	 * 获取：前悬挂系统
	 */
	public String getFrontSuspend() {
		return frontSuspend;
	}
	/**
	 * 设置：内饰风格
	 */
	public void setInsideDeckStyle(String insideDeckStyle) {
		this.insideDeckStyle = insideDeckStyle;
	}
	/**
	 * 获取：内饰风格
	 */
	public String getInsideDeckStyle() {
		return insideDeckStyle;
	}
	/**
	 * 设置：业务是否启用：0未1是
	 */
	public void setBusinessEnable(Integer businessEnable) {
		this.businessEnable = businessEnable;
	}
	/**
	 * 获取：业务是否启用：0未1是
	 */
	public Integer getBusinessEnable() {
		return businessEnable;
	}
	/**
	 * 设置：是否删除：0未1是
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	/**
	 * 获取：是否删除：0未1是
	 */
	public String getDelFlg() {
		return delFlg;
	}
	/**
	 * 设置：创建者
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建者
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改者
	 */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	/**
	 * 获取：修改者
	 */
	public String getModifier() {
		return modifier;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
}
