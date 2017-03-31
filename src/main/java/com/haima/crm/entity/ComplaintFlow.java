package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.haima.crm.vo.PageVo;

/**
 * 记录投诉审核信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ComplaintFlow extends PageVo implements Serializable {
	private static final long serialVersionUID = 1L;

	// 序号
	private Integer id;
	// 投诉单id
	private Long complainId;
	// 所属店
	private String store;
	// 申请人
	private String proposer;
	// 申请日期
	private Date porposDate;
	// 回访状态(0:不需要回访 1:待回访);
	private String callbackStatus;
	// 回访时间
	private Date callbackTime;
	// 审核人
	private String checker;
	// 审核意见
	private String checkInfo;
	// 审核状态
	private String checkStatus;
	// 审核日期
	private Date checkDate;
	// 创建人
	private String createBy;
	// 创建时间
	private Date createTime;
	// 更新人
	private String updateBy;
	// 更新时间
	private Date updateTime;
	
	private List<Long> complaintIds;

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

	public Long getComplainId() {
		return complainId;
	}

	public void setComplainId(Long complainId) {
		this.complainId = complainId;
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
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	/**
	 * 获取：审核状态
	 */
	public String getCheckStatus() {
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

	public String getCallbackStatus() {
		return callbackStatus;
	}

	public void setCallbackStatus(String callbackStatus) {
		this.callbackStatus = callbackStatus;
	}

	public Date getCallbackTime() {
		return callbackTime;
	}

	public void setCallbackTime(Date callbackTime) {
		this.callbackTime = callbackTime;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public List<Long> getComplaintIds() {
		return complaintIds;
	}

	public void setComplaintIds(List<Long> complaintIds) {
		this.complaintIds = complaintIds;
	}
}
