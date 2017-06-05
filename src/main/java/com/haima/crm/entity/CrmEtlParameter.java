package com.haima.crm.entity;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-05-21 18:12
 */
public class CrmEtlParameter {
    /**
     * 调度时间,每天的几点多少分钟
     */
    private int minutes;
    /**
     * 调度时间,每天的几点
     */
    private int hour;
    /**
     * 调度时间,间隔xx天
     */
    private long intervalDays;
    /**
     * 调度时间,间隔xx天xx消失
     */
    private long intervalHours;
    /**
     * (调度参数)jobId
     */
    private String jobName;
    /**
     * 调度时间方式,时间间隔 1 或  每天的时间点 2
     */
    private int schedulerType;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public long getIntervalDays() {
        return intervalDays;
    }

    public void setIntervalDays(long intervalDays) {
        this.intervalDays = intervalDays;
    }

    public long getIntervalHours() {
        return intervalHours;
    }

    public void setIntervalHours(long intervalHours) {
        this.intervalHours = intervalHours;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getSchedulerType() {
        return schedulerType;
    }

    public void setSchedulerType(int schedulerType) {
        this.schedulerType = schedulerType;
    }
}
