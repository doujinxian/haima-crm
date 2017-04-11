package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-11 17:25:30
 */
public class CarColor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//车id
	private Integer carId;
	//颜色id
	private Integer colorId;
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
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：车id
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	/**
	 * 获取：车id
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * 设置：颜色id
	 */
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	/**
	 * 获取：颜色id
	 */
	public Integer getColorId() {
		return colorId;
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
