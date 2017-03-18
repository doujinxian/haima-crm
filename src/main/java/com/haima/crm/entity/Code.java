package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-17 20:15:12
 */
public class Code implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//编码类型
	private String type;
	//编码
	private String code;
	//编码名
	private String name;
	//备注
	private String remark;
	//显示顺
	private Integer order;
	//是否删除 1-删除 0-未删除
	private String delFlg;
	//创建者
	private String creator;
	//创建时间
	private Date createDate;
	//修改者
	private String modifier;
	//修改时间
	private Date modifyDate;

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
	 * 设置：编码类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：编码类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：编码名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：编码名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：显示顺
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：显示顺
	 */
	public Integer getOrder() {
		return order;
	}
	/**
	 * 设置：是否删除 1-删除 0-未删除
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	/**
	 * 获取：是否删除 1-删除 0-未删除
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
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
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
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
}
