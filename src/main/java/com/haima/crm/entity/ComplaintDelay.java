package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 投诉延迟申请表
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public class ComplaintDelay implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer id;
	//投诉单id
	private Long complainId;
	//投诉单号
	private String complainCode;
	//申请日期
	private Date porposDate;
	//延迟理由
	private String delayReason;
	//预计完成时间
	private Date estimateFinishTime;
	//审核人
	private String checker;
	//审核意见
	private String checkInfo;
	//审核日期
	private Date checkDate;
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
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：序号
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：投诉单id
	 */
	public void setComplainId(Long complainId) {
		this.complainId = complainId;
	}
	/**
	 * 获取：投诉单id
	 */
	public Long getComplainId() {
		return complainId;
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
	 * 设置：申请日期
	 */
	public void setPorposDate(Date porposDate) {
		this.porposDate = porposDate;
	}
	/**
	 * 获取：申请日期
	 */
	public Date getPorposDate() {
		return porposDate;
	}
	/**
	 * 设置：延迟理由
	 */
	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}
	/**
	 * 获取：延迟理由
	 */
	public String getDelayReason() {
		return delayReason;
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
	 * 设置：审核人
	 */
	public void setChecker(String checker) {
		this.checker = checker;
	}
	/**
	 * 获取：审核人
	 */
	public String getChecker() {
		return checker;
	}
	/**
	 * 设置：审核意见
	 */
	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}
	/**
	 * 获取：审核意见
	 */
	public String getCheckInfo() {
		return checkInfo;
	}
	/**
	 * 设置：审核日期
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	/**
	 * 获取：审核日期
	 */
	public Date getCheckDate() {
		return checkDate;
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
}
