package com.haima.crm.dto;

import java.util.Date;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-04-15 22:11
 */
public class CustomerCarDTO {
    // vin码
    private String vin;
    //客户ID
    private Long customerId;
    //车主姓名
    private String customerName;
    //移动电话
    private String phone;
    // 车牌号
    private String plateNo;
    // 销售服务店（服务）
    private String salesServicesService;
    //车系
    private String carSeriesName;
    //车型代码
    private String carModelCode;
    //车型名称
    private String carModelName;
    //购车日期
    private Date purchaseDate;
    //车颜色
    private String colorName;
    //moofun账号
    private Integer moofunId;
    //身份证号
    private String idNo;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getCustomerId() { return customerId; }

    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getCustomerName() {
        return customerName;
    }

    public String getCarModelCode() {
        return carModelCode;
    }

    public void setCarModelCode(String carModelCode) {
        this.carModelCode = carModelCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getSalesServicesService() {
        return salesServicesService;
    }

    public void setSalesServicesService(String salesServicesService) {
        this.salesServicesService = salesServicesService;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

	public Integer getMoofunId() {
		return moofunId;
	}

	public void setMoofunId(Integer moofunId) {
		this.moofunId = moofunId;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
}
