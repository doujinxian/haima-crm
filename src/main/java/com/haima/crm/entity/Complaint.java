package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 记录投诉信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Long id;
	//投诉单号
	private String complainCode;
	//客户ID
	private Long customerId;
	//客户姓名
	private String custormerName;
	//联系电话
	private String phoneNo;
	//VIN码
	private String vin;
	//车牌号
	private String plateNo;
	//车型代码
	private String vno;
	//购车日期
	private Date buyDate;
	//投诉类型
	private String complainType;
	//投诉级别
	private String complainLevel;
	//投诉时间
	private Date complainTime;
	//需完成时间
	private Date finishTime;
	//投诉关闭时间
	private Date closeTime;
	//城市
	private String city;
	//投诉来源
	private String complainSource;
	//销售服务店（服务）
	private String salesServicesService;
	//投诉状态
	private String complainStatus;
	//回访状态
	private String callbackStatus;
	//回访时间
	private Date callbackTime;
	//车辆颜色
	private String carColor;
	//行驶里程
	private Integer mileage;
	//投诉基地
	private String complainBase;
	//区域
	private String area;
	//客户来电次数
	private Integer callTimes;
	//档案编号
	private String fileNo;
	//投诉管理员
	private String complainAdmin;
	//接收人
	private String receivedBy;
	//转发时间
	private Date transTime;
	//涉及其他公共机构
	private String otherMsg;
	//车辆名称
	private String carName;
	//跟踪人
	private String traceBy;
	//记录人
	private String recordBy;
	//销售服务店
	private String salesServicesStore;
	//预计完成时间
	private Date estimateFinishTime;
	//客户级别
	private String customerLevel;
	//满意度
	private String satisfactionDegree;
	//删除标识
	private Integer delFlag;
	//创建人
	private String createBy;
	//创建时间
	private Date createTime;
	//更新人
	private String updateBy;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：序号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：序号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：投诉单号
	 */
	public void setComplainCode(String complainCode) {
		this.complainCode = complainCode;
	}
	/**
	 * 获取：投诉单号
	 */
	public String getComplainCode() {
		return complainCode;
	}
	/**
	 * 设置：客户ID
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：客户ID
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：客户姓名
	 */
	public void setCustormerName(String custormerName) {
		this.custormerName = custormerName;
	}
	/**
	 * 获取：客户姓名
	 */
	public String getCustormerName() {
		return custormerName;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * 设置：VIN码
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * 获取：VIN码
	 */
	public String getVin() {
		return vin;
	}
	/**
	 * 设置：车牌号
	 */
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	/**
	 * 获取：车牌号
	 */
	public String getPlateNo() {
		return plateNo;
	}
	/**
	 * 设置：车型代码
	 */
	public void setVno(String vno) {
		this.vno = vno;
	}
	/**
	 * 获取：车型代码
	 */
	public String getVno() {
		return vno;
	}
	/**
	 * 设置：购车日期
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	/**
	 * 获取：购车日期
	 */
	public Date getBuyDate() {
		return buyDate;
	}
	/**
	 * 设置：投诉类型
	 */
	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}
	/**
	 * 获取：投诉类型
	 */
	public String getComplainType() {
		return complainType;
	}
	/**
	 * 设置：投诉级别
	 */
	public void setComplainLevel(String complainLevel) {
		this.complainLevel = complainLevel;
	}
	/**
	 * 获取：投诉级别
	 */
	public String getComplainLevel() {
		return complainLevel;
	}
	/**
	 * 设置：投诉时间
	 */
	public void setComplainTime(Date complainTime) {
		this.complainTime = complainTime;
	}
	/**
	 * 获取：投诉时间
	 */
	public Date getComplainTime() {
		return complainTime;
	}
	/**
	 * 设置：需完成时间
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	/**
	 * 获取：需完成时间
	 */
	public Date getFinishTime() {
		return finishTime;
	}
	/**
	 * 设置：投诉关闭时间
	 */
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	/**
	 * 获取：投诉关闭时间
	 */
	public Date getCloseTime() {
		return closeTime;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：投诉来源
	 */
	public void setComplainSource(String complainSource) {
		this.complainSource = complainSource;
	}
	/**
	 * 获取：投诉来源
	 */
	public String getComplainSource() {
		return complainSource;
	}
	/**
	 * 设置：销售服务店（服务）
	 */
	public void setSalesServicesService(String salesServicesService) {
		this.salesServicesService = salesServicesService;
	}
	/**
	 * 获取：销售服务店（服务）
	 */
	public String getSalesServicesService() {
		return salesServicesService;
	}
	/**
	 * 设置：投诉状态
	 */
	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}
	/**
	 * 获取：投诉状态
	 */
	public String getComplainStatus() {
		return complainStatus;
	}
	/**
	 * 设置：回访状态
	 */
	public void setCallbackStatus(String callbackStatus) {
		this.callbackStatus = callbackStatus;
	}
	/**
	 * 获取：回访状态
	 */
	public String getCallbackStatus() {
		return callbackStatus;
	}
	/**
	 * 设置：回访时间
	 */
	public void setCallbackTime(Date callbackTime) {
		this.callbackTime = callbackTime;
	}
	/**
	 * 获取：回访时间
	 */
	public Date getCallbackTime() {
		return callbackTime;
	}
	/**
	 * 设置：车辆颜色
	 */
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	/**
	 * 获取：车辆颜色
	 */
	public String getCarColor() {
		return carColor;
	}
	/**
	 * 设置：行驶里程
	 */
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	/**
	 * 获取：行驶里程
	 */
	public Integer getMileage() {
		return mileage;
	}
	/**
	 * 设置：投诉基地
	 */
	public void setComplainBase(String complainBase) {
		this.complainBase = complainBase;
	}
	/**
	 * 获取：投诉基地
	 */
	public String getComplainBase() {
		return complainBase;
	}
	/**
	 * 设置：区域
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：区域
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：客户来电次数
	 */
	public void setCallTimes(Integer callTimes) {
		this.callTimes = callTimes;
	}
	/**
	 * 获取：客户来电次数
	 */
	public Integer getCallTimes() {
		return callTimes;
	}
	/**
	 * 设置：档案编号
	 */
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	/**
	 * 获取：档案编号
	 */
	public String getFileNo() {
		return fileNo;
	}
	/**
	 * 设置：投诉管理员
	 */
	public void setComplainAdmin(String complainAdmin) {
		this.complainAdmin = complainAdmin;
	}
	/**
	 * 获取：投诉管理员
	 */
	public String getComplainAdmin() {
		return complainAdmin;
	}
	/**
	 * 设置：接收人
	 */
	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}
	/**
	 * 获取：接收人
	 */
	public String getReceivedBy() {
		return receivedBy;
	}
	/**
	 * 设置：转发时间
	 */
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	/**
	 * 获取：转发时间
	 */
	public Date getTransTime() {
		return transTime;
	}
	/**
	 * 设置：涉及其他公共机构
	 */
	public void setOtherMsg(String otherMsg) {
		this.otherMsg = otherMsg;
	}
	/**
	 * 获取：涉及其他公共机构
	 */
	public String getOtherMsg() {
		return otherMsg;
	}
	/**
	 * 设置：车辆名称
	 */
	public void setCarName(String carName) {
		this.carName = carName;
	}
	/**
	 * 获取：车辆名称
	 */
	public String getCarName() {
		return carName;
	}
	/**
	 * 设置：跟踪人
	 */
	public void setTraceBy(String traceBy) {
		this.traceBy = traceBy;
	}
	/**
	 * 获取：跟踪人
	 */
	public String getTraceBy() {
		return traceBy;
	}
	/**
	 * 设置：记录人
	 */
	public void setRecordBy(String recordBy) {
		this.recordBy = recordBy;
	}
	/**
	 * 获取：记录人
	 */
	public String getRecordBy() {
		return recordBy;
	}
	/**
	 * 设置：销售服务店
	 */
	public void setSalesServicesStore(String salesServicesStore) {
		this.salesServicesStore = salesServicesStore;
	}
	/**
	 * 获取：销售服务店
	 */
	public String getSalesServicesStore() {
		return salesServicesStore;
	}
	/**
	 * 设置：预计完成时间
	 */
	public void setEstimateFinishTime(Date estimateFinishTime) {
		this.estimateFinishTime = estimateFinishTime;
	}
	/**
	 * 获取：预计完成时间
	 */
	public Date getEstimateFinishTime() {
		return estimateFinishTime;
	}
	/**
	 * 设置：客户级别
	 */
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	/**
	 * 获取：客户级别
	 */
	public String getCustomerLevel() {
		return customerLevel;
	}
	/**
	 * 设置：删除标识
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：删除标识
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateBy() {
		return createBy;
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
	 * 设置：更新人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public String getSatisfactionDegree() {
		return satisfactionDegree;
	}
	public void setSatisfactionDegree(String satisfactionDegree) {
		this.satisfactionDegree = satisfactionDegree;
	}
	
}
