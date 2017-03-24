package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;



/**
 * 记录投诉审核信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ComplaintFlow implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer id;
	//投诉单号
	private String complainCode;
	//审核类型
	private Integer checkType;
	//申请人
	private String proposer;
	//审核人
	private String checker;
	//申请日期
	private Date porposDate;
	//审核意见
	private String checkInfo;
	//审核状态
	private Integer checkStatus;
	//审核日期
	private Date checkDate;
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
	 * 设置：审核类型
	 */
	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}
	/**
	 * 获取：审核类型
	 */
	public Integer getCheckType() {
		return checkType;
	}
	/**
	 * 设置：申请人
	 */
	public void setProposer(String proposer) {
		this.proposer = proposer;
	}
	/**
	 * 获取：申请人
	 */
	public String getProposer() {
		return proposer;
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
	 * 设置：审核状态
	 */
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}
	/**
	 * 获取：审核状态
	 */
	public Integer getCheckStatus() {
		return checkStatus;
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
