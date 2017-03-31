package com.haima.crm.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.haima.crm.entity.ComplaintDealLog;
import com.haima.crm.entity.ComplaintDelay;
import com.haima.crm.entity.ComplaintFlow;

/**
 * 记录投诉信息
 * 
 * @author doujinxian
 * @email doujinxian@126.com
 * @date 2017-03-23 19:55:46
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ComplaintVo extends PageVo implements Serializable {
	private static final long serialVersionUID = 3039098009796294741L;
	// 开始时间
	private Date complainTimeStart;
	//结束时间
	private Date complainTimeEnd;
	//是否查询延迟申请信息
	private Boolean ifSelectDelayInfo;
	//是否查询申请关闭信息
	private Boolean ifSelectFlowInfo;
	// 投诉内容
	private List<ComplaintDealLog> complaintDealLogs;
	// 延迟记录
	private ComplaintDelay complaintDelay;
	// 记录投诉审核信息
	private ComplaintFlow complaintFlow;
	
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
	public List<ComplaintDealLog> getComplaintDealLogs() {
		return complaintDealLogs;
	}
	public void setComplaintDealLogs(List<ComplaintDealLog> complaintDealLogs) {
		this.complaintDealLogs = complaintDealLogs;
	}
	public ComplaintDelay getComplaintDelay() {
		return complaintDelay;
	}
	public void setComplaintDelay(ComplaintDelay complaintDelay) {
		this.complaintDelay = complaintDelay;
	}
	public ComplaintFlow getComplaintFlow() {
		return complaintFlow;
	}
	public void setComplaintFlow(ComplaintFlow complaintFlow) {
		this.complaintFlow = complaintFlow;
	}
	public Boolean getIfSelectDelayInfo() {
		return ifSelectDelayInfo;
	}
	public void setIfSelectDelayInfo(Boolean ifSelectDelayInfo) {
		this.ifSelectDelayInfo = ifSelectDelayInfo;
	}
	public Boolean getIfSelectFlowInfo() {
		return ifSelectFlowInfo;
	}
	public void setIfSelectFlowInfo(Boolean ifSelectFlowInfo) {
		this.ifSelectFlowInfo = ifSelectFlowInfo;
	}
}
