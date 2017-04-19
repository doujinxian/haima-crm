package com.haima.crm.entity;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;



/**
 * 
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-04-18 18:30:13
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long customerId;
	//
	private Long pcId;
	//
	private Long moofunId;
	//车主姓名
	private String customerName;
	//性别: 0-未知; 1-男; 2-女
	private String sex;
	//婚姻状况1-未婚 2-已婚
	private String maritalStatus;
	//证件类型 默认0:身份证
	private String idType;
	//身份证号码/机构代码
	private String idNo;
	//生日
	private String birthday;
	//移动电话
	private String phone;
	//办公电话
	private String companyPhone;
	//家庭电话
	private String familyPhone;
	//地址
	private String address;
	//邮政编码
	private String zipcode;
	//省份
	private Integer province;
	//城市
	private Integer city;
	//区/县
	private Integer district;
	//区域
	private String area;
	//客户类型1 A类客户 B类客户 C类客户 D类客户
	private String customerType1;
	//1-一类客户 2-二类客户 3-三类客户 4-四类客户
	private String customerType2;
	//职业
	private String occupation;
	//学历
	private String education;
	//工作单位
	private String company;
	//职位
	private String position;
	//国籍
	private String country;
	//方便回访时间
	private String profitRevisitTime;
	//车主照片
	private String photograph;
	//电子邮箱
	private String email;
	//QQ号
	private String qq;
	//微信
	private String wechat;
	//微博
	private String weibo;
	//了解渠道
	private String knowFrom;
	//备注
	private String remark;
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
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：
	 */
	public Long getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：
	 */
	public void setPcId(Long pcId) {
		this.pcId = pcId;
	}
	/**
	 * 获取：
	 */
	public Long getPcId() {
		return pcId;
	}
	/**
	 * 设置：
	 */
	public void setMoofunId(Long moofunId) {
		this.moofunId = moofunId;
	}
	/**
	 * 获取：
	 */
	public Long getMoofunId() {
		return moofunId;
	}
	/**
	 * 设置：车主姓名
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：车主姓名
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：性别: 0-未知; 1-男; 2-女
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别: 0-未知; 1-男; 2-女
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：婚姻状况1-未婚 2-已婚
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	/**
	 * 获取：婚姻状况1-未婚 2-已婚
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * 设置：证件类型 默认0:身份证
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：证件类型 默认0:身份证
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置：身份证号码/机构代码
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：身份证号码/机构代码
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：生日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：生日
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 设置：移动电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：移动电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：办公电话
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	/**
	 * 获取：办公电话
	 */
	public String getCompanyPhone() {
		return companyPhone;
	}
	/**
	 * 设置：家庭电话
	 */
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	/**
	 * 获取：家庭电话
	 */
	public String getFamilyPhone() {
		return familyPhone;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * 设置：省份
	 */
	public void setProvince(Integer province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public Integer getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public Integer getCity() {
		return city;
	}
	/**
	 * 设置：区/县
	 */
	public void setDistrict(Integer district) {
		this.district = district;
	}
	/**
	 * 获取：区/县
	 */
	public Integer getDistrict() {
		return district;
	}
	/**
	 * 设置：区域
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：区域
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：客户类型1 A类客户 B类客户 C类客户 D类客户
	 */
	public void setCustomerType1(String customerType1) {
		this.customerType1 = customerType1;
	}
	/**
	 * 获取：客户类型1 A类客户 B类客户 C类客户 D类客户
	 */
	public String getCustomerType1() {
		return customerType1;
	}
	/**
	 * 设置：1-一类客户 2-二类客户 3-三类客户 4-四类客户
	 */
	public void setCustomerType2(String customerType2) {
		this.customerType2 = customerType2;
	}
	/**
	 * 获取：1-一类客户 2-二类客户 3-三类客户 4-四类客户
	 */
	public String getCustomerType2() {
		return customerType2;
	}
	/**
	 * 设置：职业
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * 获取：职业
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * 设置：学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：学历
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：工作单位
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * 获取：工作单位
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * 设置：职位
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：职位
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：国籍
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国籍
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：方便回访时间
	 */
	public void setProfitRevisitTime(String profitRevisitTime) {
		this.profitRevisitTime = profitRevisitTime;
	}
	/**
	 * 获取：方便回访时间
	 */
	public String getProfitRevisitTime() {
		return profitRevisitTime;
	}
	/**
	 * 设置：车主照片
	 */
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}
	/**
	 * 获取：车主照片
	 */
	public String getPhotograph() {
		return photograph;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：QQ号
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：QQ号
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：微信
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * 获取：微信
	 */
	public String getWechat() {
		return wechat;
	}
	/**
	 * 设置：微博
	 */
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	/**
	 * 获取：微博
	 */
	public String getWeibo() {
		return weibo;
	}
	/**
	 * 设置：了解渠道
	 */
	public void setKnowFrom(String knowFrom) {
		this.knowFrom = knowFrom;
	}
	/**
	 * 获取：了解渠道
	 */
	public String getKnowFrom() {
		return knowFrom;
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
