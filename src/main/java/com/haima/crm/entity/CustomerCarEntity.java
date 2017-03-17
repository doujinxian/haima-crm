package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:13
 */
public class CustomerCarEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//客户id
	private Long customerId;
	//vin码
	private String vin;
	//车牌号
	private String plateNo;
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
	 * 设置：vin码
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * 获取：vin码
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
