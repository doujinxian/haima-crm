package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 记录投诉转发信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public class ComplaintForward implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer id;
	//投诉单号
	private String complainCode;
	//转发来自
	private String forwardFrom;
	//转发给
	private String forwardTo;
	//处理记录
	private String handleMsg;
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
	 * 设置：转发来自
	 */
	public void setForwardFrom(String forwardFrom) {
		this.forwardFrom = forwardFrom;
	}
	/**
	 * 获取：转发来自
	 */
	public String getForwardFrom() {
		return forwardFrom;
	}
	/**
	 * 设置：转发给
	 */
	public void setForwardTo(String forwardTo) {
		this.forwardTo = forwardTo;
	}
	/**
	 * 获取：转发给
	 */
	public String getForwardTo() {
		return forwardTo;
	}
	/**
	 * 设置：处理记录
	 */
	public void setHandleMsg(String handleMsg) {
		this.handleMsg = handleMsg;
	}
	/**
	 * 获取：处理记录
	 */
	public String getHandleMsg() {
		return handleMsg;
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
