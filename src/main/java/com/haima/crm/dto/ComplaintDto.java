package com.haima.crm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.haima.crm.vo.PageVo;

/**
 * 投诉单查询参数
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:46
 */
@ApiModel(description="投诉单查询参数")
public class ComplaintDto extends PageVo implements Serializable {
	private static final long serialVersionUID = 1L;

	// 序号
	@ApiModelProperty(name="主键")
	private Long id;
	// 投诉单号
	private String complainCode;
	// 客户ID
	private Long customerId;
	// 客户姓名
	private String custormerName;
	// 联系电话
	private String phoneNo;
	// VIN码
	private String vin;
	// 车牌号
	private String plateNo;
	// 车型代码
	private String vno;
	// 投诉类型
	private String complainType;
	// 投诉级别
	private String complainLevel;
	// 城市
	private String city;
	// 投诉来源
	private String complainSource;
	// 销售服务店（服务）
	private String salesServicesService;
	// 服务店代码
	private String salesServicesCode;
	// 投诉状态 (0:未处理,1:处理中 3:申请关闭,4:已关闭)
	private String complainStatus;
	// 回访状态 (0:待回访 1:已回访 2:回访成功 3:回访失败);
	private String callbackStatus;
	// 转发状态 0 ：未转发、1：已经发
	private String forwardStatus;
	// 申请延迟状态(0 ：未延迟、1：已申请 :2： 已批复)
	private String delayStatus;
	// 分配状态(0：未分配:1：已分配:2:已更换 )
	private String distributeStatus;
	// 车辆颜色
	private String carColor;
	// 投诉基地
	private String complainBase;
	// 区域
	private String area;
	// 档案编号
	private String fileNo;
	// 投诉管理员
	private String complainAdmin;
	// 接收人
	private String receivedBy;
	// 车辆名称
	private String carName;
	// 跟踪人
	private String traceBy;
	// 记录人
	private String recordBy;
	// 销售服务店
	private String salesServicesStore;
	// 投诉内容
	private String complaintContent;
	// 满意度
	private String satisfactionDegree;
	// 客户级别
	private String customerLevel;
	// 创建人
	private String createBy;
	// 更新人
	private String updateBy;

	// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date complainTimeStart;
	// 结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date complainTimeEnd;
	// 是否查询延迟申请信息
	private Boolean ifSelectDelayInfo;
	// 是否查询申请关闭信息
	private Boolean ifSelectFlowInfo;
	//是否及时转发 1：是 2：否
	private String forwardOnTime;
	//是否及时响应 1：是 2：否
	private String respondOnTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComplainCode() {
		return complainCode;
	}

	public void setComplainCode(String complainCode) {
		this.complainCode = complainCode;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustormerName() {
		return custormerName;
	}

	public void setCustormerName(String custormerName) {
		this.custormerName = custormerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getVno() {
		return vno;
	}

	public void setVno(String vno) {
		this.vno = vno;
	}

	public String getComplainType() {
		return complainType;
	}

	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}

	public String getComplainLevel() {
		return complainLevel;
	}

	public void setComplainLevel(String complainLevel) {
		this.complainLevel = complainLevel;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComplainSource() {
		return complainSource;
	}

	public void setComplainSource(String complainSource) {
		this.complainSource = complainSource;
	}

	public String getSalesServicesService() {
		return salesServicesService;
	}

	public void setSalesServicesService(String salesServicesService) {
		this.salesServicesService = salesServicesService;
	}

	public String getSalesServicesCode() {
		return salesServicesCode;
	}

	public void setSalesServicesCode(String salesServicesCode) {
		this.salesServicesCode = salesServicesCode;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public String getCallbackStatus() {
		return callbackStatus;
	}

	public void setCallbackStatus(String callbackStatus) {
		this.callbackStatus = callbackStatus;
	}

	public String getForwardStatus() {
		return forwardStatus;
	}

	public void setForwardStatus(String forwardStatus) {
		this.forwardStatus = forwardStatus;
	}

	public String getDelayStatus() {
		return delayStatus;
	}

	public void setDelayStatus(String delayStatus) {
		this.delayStatus = delayStatus;
	}

	public String getDistributeStatus() {
		return distributeStatus;
	}

	public void setDistributeStatus(String distributeStatus) {
		this.distributeStatus = distributeStatus;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getComplainBase() {
		return complainBase;
	}

	public void setComplainBase(String complainBase) {
		this.complainBase = complainBase;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getComplainAdmin() {
		return complainAdmin;
	}

	public void setComplainAdmin(String complainAdmin) {
		this.complainAdmin = complainAdmin;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getTraceBy() {
		return traceBy;
	}

	public void setTraceBy(String traceBy) {
		this.traceBy = traceBy;
	}

	public String getRecordBy() {
		return recordBy;
	}

	public void setRecordBy(String recordBy) {
		this.recordBy = recordBy;
	}

	public String getSalesServicesStore() {
		return salesServicesStore;
	}

	public void setSalesServicesStore(String salesServicesStore) {
		this.salesServicesStore = salesServicesStore;
	}

	public String getComplaintContent() {
		return complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		this.complaintContent = complaintContent;
	}

	public String getSatisfactionDegree() {
		return satisfactionDegree;
	}

	public void setSatisfactionDegree(String satisfactionDegree) {
		this.satisfactionDegree = satisfactionDegree;
	}

	public String getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getComplainTimeStart() {
		return complainTimeStart;
	}

	public void setComplainTimeStart(Date complainTimeStart) {
		this.complainTimeStart = complainTimeStart;
	}

	public Date getComplainTimeEnd() {
		return complainTimeEnd;
	}

	public void setComplainTimeEnd(Date complainTimeEnd) {
		this.complainTimeEnd = complainTimeEnd;
	}

	public Boolean getIfSelectDelayInfo() {
		return ifSelectDelayInfo;
	}

	public void setIfSelectDelayInfo(Boolean ifSelectDelayInfo) {
		this.ifSelectDelayInfo = ifSelectDelayInfo;
	}

	public Boolean getIfSelectFlowInfo() {
		return ifSelectFlowInfo;
	}

	public void setIfSelectFlowInfo(Boolean ifSelectFlowInfo) {
		this.ifSelectFlowInfo = ifSelectFlowInfo;
	}

	public String getForwardOnTime() {
		return forwardOnTime;
	}

	public void setForwardOnTime(String forwardOnTime) {
		this.forwardOnTime = forwardOnTime;
	}

	public String getRespondOnTime() {
		return respondOnTime;
	}

	public void setRespondOnTime(String respondOnTime) {
		this.respondOnTime = respondOnTime;
	}
}
