package com.haima.crm.vo;

import com.haima.crm.vo.PageVo;

import java.io.Serializable;
import java.util.Date;

/**
 * 记录投诉信息
 *
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-08 14:35:32
 */
public class ComplaintStatisticsVo extends PageVo implements Serializable {

    // 投诉类型
    private String complainType;
    // 开始时间
    private Date complainTimeStart;
    //结束时间
    private Date complainTimeEnd;
    // 销售服务店（服务）
    private String salesServicesService;
    // 服务店代码
    private String salesServicesCode;
    //统计类型
    private String statisticsType;

    public String getComplainType() {
        return complainType;
    }

    public void setComplainType(String complainType) {
        this.complainType = complainType;
    }

    public Date getComplainTimeStart() {
        return complainTimeStart;
    }

    public void setComplainTimeStart(Date complainTimeStart) {
        this.complainTimeStart = complainTimeStart;
    }

    public Date getComplainTimeEnd() {
        return complainTimeEnd;
    }

    public void setComplainTimeEnd(Date complainTimeEnd) {
        this.complainTimeEnd = complainTimeEnd;
    }

    public String getSalesServicesService() {
        return salesServicesService;
    }

    public void setSalesServicesService(String salesServicesService) {
        this.salesServicesService = salesServicesService;
    }

    public String getSalesServicesCode() {
        return salesServicesCode;
    }

    public void setSalesServicesCode(String salesServicesCode) {
        this.salesServicesCode = salesServicesCode;
    }

    public String getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(String statisticsType) {
        this.statisticsType = statisticsType;
    }
}
