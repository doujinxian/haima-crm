package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:29
 */
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//车id
	private Integer carId;
	//车系id
	private Integer carSeriesId;
	//车系代码
	private String carSeriesCode;
	//车型id
	private Integer carModelId;
	//车型代码
	private String carModelCode;
	//装备id
	private Integer carSetupId;
	//车装备代码
	private String carSetupCode;
	//车装备名称
	private String carSetupName;
	//加速时间
	private String toHundredTime;
	//百公里油耗
	private String useOilValue;
	//原厂标准
	private Integer isHqStand;
	//市场指导价
	private Integer retailPrice;
	//成本价
	private Integer costPrice;
	//财务类型
	private Long financeType;
	//是否优惠 0：不优惠，1：优惠
	private Integer isDiscount;
	//所属中转库 id
	private Integer entrepotId;
	//排放标准
	private String letstand;
	//最大功率
	private String maxPower;
	//最高车速
	private String maxSpeed;
	//最大总质量
	private String maxTotalMass;
	//最大扭矩
	private String maxTurnSpace;
	//车型简称
	private String modelSimple;
	//年款
	private String modelYear;
	//燃油型号 93、95
	private String oil;
	//油箱容积
	private String oilBoxVolume;
	//轮胎型号
	private String ringModel;
	//装备质量
	private String setupMass;
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
	 * 设置：车id
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车id
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：车系id
	 */
	public void setCarSeriesId(Integer carSeriesId) {
		this.carSeriesId = carSeriesId;
	}
	/**
	 * 获取：车系id
	 */
	public Integer getCarSeriesId() {
		return carSeriesId;
	}
	/**
	 * 设置：车系代码
	 */
	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}
	/**
	 * 获取：车系代码
	 */
	public String getCarSeriesCode() {
		return carSeriesCode;
	}
	/**
	 * 设置：车型id
	 */
	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}
	/**
	 * 获取：车型id
	 */
	public Integer getCarModelId() {
		return carModelId;
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
	 * 设置：装备id
	 */
	public void setCarSetupId(Integer carSetupId) {
		this.carSetupId = carSetupId;
	}
	/**
	 * 获取：装备id
	 */
	public Integer getCarSetupId() {
		return carSetupId;
	}
	/**
	 * 设置：车装备代码
	 */
	public void setCarSetupCode(String carSetupCode) {
		this.carSetupCode = carSetupCode;
	}
	/**
	 * 获取：车装备代码
	 */
	public String getCarSetupCode() {
		return carSetupCode;
	}
	/**
	 * 设置：车装备名称
	 */
	public void setCarSetupName(String carSetupName) {
		this.carSetupName = carSetupName;
	}
	/**
	 * 获取：车装备名称
	 */
	public String getCarSetupName() {
		return carSetupName;
	}
	/**
	 * 设置：加速时间
	 */
	public void setToHundredTime(String toHundredTime) {
		this.toHundredTime = toHundredTime;
	}
	/**
	 * 获取：加速时间
	 */
	public String getToHundredTime() {
		return toHundredTime;
	}
	/**
	 * 设置：百公里油耗
	 */
	public void setUseOilValue(String useOilValue) {
		this.useOilValue = useOilValue;
	}
	/**
	 * 获取：百公里油耗
	 */
	public String getUseOilValue() {
		return useOilValue;
	}
	/**
	 * 设置：原厂标准
	 */
	public void setIsHqStand(Integer isHqStand) {
		this.isHqStand = isHqStand;
	}
	/**
	 * 获取：原厂标准
	 */
	public Integer getIsHqStand() {
		return isHqStand;
	}
	/**
	 * 设置：市场指导价
	 */
	public void setRetailPrice(Integer retailPrice) {
		this.retailPrice = retailPrice;
	}
	/**
	 * 获取：市场指导价
	 */
	public Integer getRetailPrice() {
		return retailPrice;
	}
	/**
	 * 设置：成本价
	 */
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	/**
	 * 获取：成本价
	 */
	public Integer getCostPrice() {
		return costPrice;
	}
	/**
	 * 设置：财务类型
	 */
	public void setFinanceType(Long financeType) {
		this.financeType = financeType;
	}
	/**
	 * 获取：财务类型
	 */
	public Long getFinanceType() {
		return financeType;
	}
	/**
	 * 设置：是否优惠 0：不优惠，1：优惠
	 */
	public void setIsDiscount(Integer isDiscount) {
		this.isDiscount = isDiscount;
	}
	/**
	 * 获取：是否优惠 0：不优惠，1：优惠
	 */
	public Integer getIsDiscount() {
		return isDiscount;
	}
	/**
	 * 设置：所属中转库 id
	 */
	public void setEntrepotId(Integer entrepotId) {
		this.entrepotId = entrepotId;
	}
	/**
	 * 获取：所属中转库 id
	 */
	public Integer getEntrepotId() {
		return entrepotId;
	}
	/**
	 * 设置：排放标准
	 */
	public void setLetstand(String letstand) {
		this.letstand = letstand;
	}
	/**
	 * 获取：排放标准
	 */
	public String getLetstand() {
		return letstand;
	}
	/**
	 * 设置：最大功率
	 */
	public void setMaxPower(String maxPower) {
		this.maxPower = maxPower;
	}
	/**
	 * 获取：最大功率
	 */
	public String getMaxPower() {
		return maxPower;
	}
	/**
	 * 设置：最高车速
	 */
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	/**
	 * 获取：最高车速
	 */
	public String getMaxSpeed() {
		return maxSpeed;
	}
	/**
	 * 设置：最大总质量
	 */
	public void setMaxTotalMass(String maxTotalMass) {
		this.maxTotalMass = maxTotalMass;
	}
	/**
	 * 获取：最大总质量
	 */
	public String getMaxTotalMass() {
		return maxTotalMass;
	}
	/**
	 * 设置：最大扭矩
	 */
	public void setMaxTurnSpace(String maxTurnSpace) {
		this.maxTurnSpace = maxTurnSpace;
	}
	/**
	 * 获取：最大扭矩
	 */
	public String getMaxTurnSpace() {
		return maxTurnSpace;
	}
	/**
	 * 设置：车型简称
	 */
	public void setModelSimple(String modelSimple) {
		this.modelSimple = modelSimple;
	}
	/**
	 * 获取：车型简称
	 */
	public String getModelSimple() {
		return modelSimple;
	}
	/**
	 * 设置：年款
	 */
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	/**
	 * 获取：年款
	 */
	public String getModelYear() {
		return modelYear;
	}
	/**
	 * 设置：燃油型号 93、95
	 */
	public void setOil(String oil) {
		this.oil = oil;
	}
	/**
	 * 获取：燃油型号 93、95
	 */
	public String getOil() {
		return oil;
	}
	/**
	 * 设置：油箱容积
	 */
	public void setOilBoxVolume(String oilBoxVolume) {
		this.oilBoxVolume = oilBoxVolume;
	}
	/**
	 * 获取：油箱容积
	 */
	public String getOilBoxVolume() {
		return oilBoxVolume;
	}
	/**
	 * 设置：轮胎型号
	 */
	public void setRingModel(String ringModel) {
		this.ringModel = ringModel;
	}
	/**
	 * 获取：轮胎型号
	 */
	public String getRingModel() {
		return ringModel;
	}
	/**
	 * 设置：装备质量
	 */
	public void setSetupMass(String setupMass) {
		this.setupMass = setupMass;
	}
	/**
	 * 获取：装备质量
	 */
	public String getSetupMass() {
		return setupMass;
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
