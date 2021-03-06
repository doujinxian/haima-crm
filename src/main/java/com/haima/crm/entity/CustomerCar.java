package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.haima.crm.vo.CustomerCarVo;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-18 18:30:13
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CustomerCar extends CustomerCarVo implements Serializable {
	private static final long serialVersionUID = 1L;
	//主键
	private Long id;
	//客户id
	private Long customerId;
	//vin码
	private String vin;
	//车牌号
	private String plateNo;
	//车型id
	private Integer carId;
	//车颜色id
	private Integer carColorId;
	//购车日期
	private Date purchaseDate;
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
	 * 设置：车型id
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车型id
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：车颜色id
	 */
	public void setCarColorId(Integer carColorId) {
		this.carColorId = carColorId;
	}
	/**
	 * 获取：车颜色id
	 */
	public Integer getCarColorId() {
		return carColorId;
	}
	/**
	 * 设置：购车日期
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	/**
	 * 获取：购车日期
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
