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
public class Color extends PageVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//颜色id
	private Integer colorId;
	//颜色代码
	private String colorCode;
	//颜色名称
	private String colorName;
	//显示顺序
	private Integer order;
	//业务是否启用：0未1是
	private Integer businessEnable;
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
	 * 设置：颜色代码
	 */
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	/**
	 * 获取：颜色代码
	 */
	public String getColorCode() {
		return colorCode;
	}
	/**
	 * 设置：颜色名称
	 */
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	/**
	 * 获取：颜色名称
	 */
	public String getColorName() {
		return colorName;
	}
	/**
	 * 设置：显示顺序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：显示顺序
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * 设置：业务是否启用：0未1是
	 */
	public void setBusinessEnable(Integer businessEnable) {
		this.businessEnable = businessEnable;
	}
	/**
	 * 获取：业务是否启用：0未1是
	 */
	public Integer getBusinessEnable() {
		return businessEnable;
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
