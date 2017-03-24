package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:47
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CustomerContact implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//联系人id
	private Long contactId;
	//客户id
	private Long customerId;
	//联系人姓名
	private String contactNm;
	//联系电话
	private String contactPhone;
	//联系地址
	private String contactAddress;
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
	 * 设置：联系人id
	 */
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	/**
	 * 获取：联系人id
	 */
	public Long getContactId() {
		return contactId;
	}
	/**
	 * 设置：客户id
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：客户id
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：联系人姓名
	 */
	public void setContactNm(String contactNm) {
		this.contactNm = contactNm;
	}
	/**
	 * 获取：联系人姓名
	 */
	public String getContactNm() {
		return contactNm;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：联系地址
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	/**
	 * 获取：联系地址
	 */
	public String getContactAddress() {
		return contactAddress;
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
