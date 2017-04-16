package com.haima.crm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 记录投诉信息
 *
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-12 14:35:32
 */
public class CrmCustomerCarVo extends PageVo implements Serializable {

    // vin码
    private String vin;
    // 车牌号
    private String plateNo;
    //车系
    private String carSeriesName;
    //车型
    private String carModelName;
    // 服务店代码
    private String salesServicesCode;
    // 销售服务店（服务）
    private String salesServicesService;
    //购车日期开始
    private Date purchaseDateStart;
    //购车日期截止
    private Date purchaseDateEnd;
    //车主姓名
    private String customerName;
    //移动电话
    private String phone;
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

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
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

    public String getSalesServicesCode() {
        return salesServicesCode;
    }

    public void setSalesServicesCode(String salesServicesCode) {
        this.salesServicesCode = salesServicesCode;
    }

    public String getSalesServicesService() {
        return salesServicesService;
    }

    public void setSalesServicesService(String salesServicesService) {
        this.salesServicesService = salesServicesService;
    }

    public Date getPurchaseDateStart() {
        return purchaseDateStart;
    }

    public void setPurchaseDateStart(Date purchaseDateStart) {
        this.purchaseDateStart = purchaseDateStart;
    }

    public Date getPurchaseDateEnd() {
        return purchaseDateEnd;
    }

    public void setPurchaseDateEnd(Date purchaseDateEnd) {
        this.purchaseDateEnd = purchaseDateEnd;
    }

    public String getCustomerName() {
        return customerName;
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
