package com.haima.crm.entity;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-09 17:26
 */
public class ComplaintStatisticsSatisfaction {
    //统计方式
    private String statisticsType;
    //投诉单数
    private int complaintCount;
    //满意数
    private int satisfactionCount;
    //一般数
    private int commonSatisfactionCount;
    //不满意数
    private int dissatisfactionCount;
    //满意度
    private String satisfactionRatio;
    //一般满意度
    private String commonSatisfactionRatio;
    //不满意度
    private String dissatisfactionRatio;

    public String getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(String statisticsType) {
        this.statisticsType = statisticsType;
    }

    public int getComplaintCount() {
        return complaintCount;
    }

    public void setComplaintCount(int complaintCount) {
        this.complaintCount = complaintCount;
    }

    public int getSatisfactionCount() {
        return satisfactionCount;
    }

    public void setSatisfactionCount(int satisfactionCount) {
        this.satisfactionCount = satisfactionCount;
    }

    public int getCommonSatisfactionCount() {
        return commonSatisfactionCount;
    }

    public void setCommonSatisfactionCount(int commonSatisfactionCount) {
        this.commonSatisfactionCount = commonSatisfactionCount;
    }

    public int getDissatisfactionCount() {
        return dissatisfactionCount;
    }

    public void setDissatisfactionCount(int dissatisfactionCount) {
        this.dissatisfactionCount = dissatisfactionCount;
    }

    public String getSatisfactionRatio() {
        return satisfactionRatio;
    }

    public void setSatisfactionRatio(String satisfactionRatio) {
        this.satisfactionRatio = satisfactionRatio;
    }

    public String getCommonSatisfactionRatio() {
        return commonSatisfactionRatio;
    }

    public void setCommonSatisfactionRatio(String commonSatisfactionRatio) {
        this.commonSatisfactionRatio = commonSatisfactionRatio;
    }

    public String getDissatisfactionRatio() {
        return dissatisfactionRatio;
    }

    public void setDissatisfactionRatio(String dissatisfactionRatio) {
        this.dissatisfactionRatio = dissatisfactionRatio;
    }
}
