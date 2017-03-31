package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;

import com.haima.crm.vo.PageVo;



/**
 * 记录投诉转发信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-30 19:39:58
 */
public class ComplaintForward extends PageVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer id;
	//投诉单id
	private Long complainId;
	//转发对象 1:总部人员  0:4S店 
	private String forwardType;
	//总部人员/4S店
	private String forwardTo;
	//处理状态
	private Integer handleStatus;
	//处理日期
	private Date handleDate;
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
	 * 设置：转发对象 1:总部人员  0:4S店 
	 */
	public void setForwardType(String forwardType) {
		this.forwardType = forwardType;
	}
	/**
	 * 获取：转发对象 1:总部人员  0:4S店 
	 */
	public String getForwardType() {
		return forwardType;
	}
	/**
	 * 设置：总部人员/4S店
	 */
	public void setForwardTo(String forwardTo) {
		this.forwardTo = forwardTo;
	}
	/**
	 * 获取：总部人员/4S店
	 */
	public String getForwardTo() {
		return forwardTo;
	}
	/**
	 * 设置：处理状态
	 */
	public void setHandleStatus(Integer handleStatus) {
		this.handleStatus = handleStatus;
	}
	/**
	 * 获取：处理状态
	 */
	public Integer getHandleStatus() {
		return handleStatus;
	}
	/**
	 * 设置：处理日期
	 */
	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}
	/**
	 * 获取：处理日期
	 */
	public Date getHandleDate() {
		return handleDate;
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
