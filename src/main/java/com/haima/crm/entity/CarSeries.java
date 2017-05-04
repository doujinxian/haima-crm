package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;

import com.haima.crm.vo.PageVo;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public class CarSeries extends PageVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//车系id
	private Integer carSeriesId;
	//车系代码
	private String carSeriesCode;
	//车系名称
	private String carSeriesName;
	//品牌
	private String brand;
	//产地
	private String origin;
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
	 * 设置：车系id
	 */
	public void setCarSeriesId(Integer carSeriesId) {
		this.carSeriesId = carSeriesId;
	}
	/**
	 * 获取：车系id
	 */
	public Integer getCarSeriesId() {
		return carSeriesId;
	}
	/**
	 * 设置：车系代码
	 */
	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}
	/**
	 * 获取：车系代码
	 */
	public String getCarSeriesCode() {
		return carSeriesCode;
	}
	/**
	 * 设置：车系名称
	 */
	public void setCarSeriesName(String carSeriesName) {
		this.carSeriesName = carSeriesName;
	}
	/**
	 * 获取：车系名称
	 */
	public String getCarSeriesName() {
		return carSeriesName;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：品牌
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 设置：产地
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * 获取：产地
	 */
	public String getOrigin() {
		return origin;
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
