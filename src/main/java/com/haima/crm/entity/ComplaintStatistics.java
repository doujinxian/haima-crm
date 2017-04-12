package com.haima.crm.entity;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-08 15:26
 */
public class ComplaintStatistics {
    //发生投诉数量
    private int complaintCount;
    //发生投诉所占全国比例
    private String complaintCountRatio;
    //关闭投诉数量
    private int closeComplaintCount;
    //关闭所占比例
    private String closeComplaintCountRatio;
    //及时关闭量
    private int timelyCloseComplaintCount;
    //投诉处理满意度
    private int complaintSatisfactionRatio;
    //投诉及时响应率
    private String timelyComplaintHandlingRatio;
    //统计方式
    private String statisticsType;
    //投诉类型
    private String complainType;

    public int getComplaintCount() {
        return complaintCount;
    }

    public void setComplaintCount(int complaintCount) {
        this.complaintCount = complaintCount;
    }

    public String getComplaintCountRatio() {
        return complaintCountRatio;
    }

    public void setComplaintCountRatio(String complaintCountRatio) {
        this.complaintCountRatio = complaintCountRatio;
    }

    public int getCloseComplaintCount() {
        return closeComplaintCount;
    }

    public void setCloseComplaintCount(int closeComplaintCount) {
        this.closeComplaintCount = closeComplaintCount;
    }

    public String getCloseComplaintCountRatio() {
        return closeComplaintCountRatio;
    }

    public void setCloseComplaintCountRatio(String closeComplaintCountRatio) {
        this.closeComplaintCountRatio = closeComplaintCountRatio;
    }

    public int getTimelyCloseComplaintCount() {
        return timelyCloseComplaintCount;
    }

    public void setTimelyCloseComplaintCount(int timelyCloseComplaintCount) {
        this.timelyCloseComplaintCount = timelyCloseComplaintCount;
    }

    public int getComplaintSatisfactionRatio() {
        return complaintSatisfactionRatio;
    }

    public void setComplaintSatisfactionRatio(int complaintSatisfactionRatio) {
        this.complaintSatisfactionRatio = complaintSatisfactionRatio;
    }

    public String getTimelyComplaintHandlingRatio() {
        return timelyComplaintHandlingRatio;
    }

    public void setTimelyComplaintHandlingRatio(String timelyComplaintHandlingRatio) {
        this.timelyComplaintHandlingRatio = timelyComplaintHandlingRatio;
    }

    public String getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(String statisticsType) {
        this.statisticsType = statisticsType;
    }

	public String getComplainType() {
		return complainType;
	}

	public void setComplainType(String complainType) {
		this.complainType = complainType;
	}
    
}
