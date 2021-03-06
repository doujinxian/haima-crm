package com.haima.crm.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jinxian.dou
 *
 */
public class CommonConstants {
	public static final String UMS_OUT_URL = "https://ums.tongter.com:8443/ums2/api";
	public static final String UMS_TICKET = "41b99d404b74f5f8bcaa224fa4e40135";
	
	// del_flag 删除标记
	public final static Integer DEL_FLAG_FALSE = 0;
	public final static Integer DEL_FLAG_TRUE = 1;

	// 投诉状态 (0:未处理,1:处理中 3:申请关闭,4:已关闭) t_complaint
	public final static String COMPLAIN_STATUS_DEFAULT = "0";
	public final static String COMPLAIN_STATUS_IN_DEAL = "1";
	public final static String COMPLAIN_STATUS_APPLY_CLOSE = "3";
	public final static String COMPLAIN_STATUS_CLOSE = "4";

	// 回访状态 (0:待回访 1:待回访 2:回访成功 3:回访失败); t_complaint
	public final static String CALLBACK_STATUS_DEFAULT = "0";
	public final static String CALLBACK_STATUS_WAIT_CALL = "1";
	public final static String CALLBACK_STATUS_CALL_SUCCESS = "2";
	public final static String CALLBACK_STATUS_CALL_FAIL = "3";

	// 转发状态 0 ：未转发、1：已经发 t_complaint
	public final static String FORWARD_STATUS_DEFAULT = "0";
	public final static String FORWARD_STATUS_HAS_FORWARD = "1";
	
	//转发对象 1:总部人员  0:4S店 
	public final static String FORWARD_TYPE_USER = "1";
	public final static String FORWARD_TYPE_4S_SOTORE = "0";
	
	// 申请延迟状态(0 ：未延迟、1：已申请 :2： 已批复) t_complaint
	public final static String DELAY_STATUS_DEFAULT = "0";
	public final static String DELAY_STATUS_APPLIED = "1";
	public final static String DELAY_STATUS_AUDIT = "2";

	// 分配状态(0：未分配:1：已分配:2:已更换 ) t_complaint
	public final static String DISTRIBUTE_STATUS_DEFAULT = "0";
	public final static String DISTRIBUTE_STATUS_DISTRIBUTED = "1";
	public final static String DISTRIBUTE_STATUS_CHANGED = "2";

	// 批复状态（0：默认 1：同意，2：不同意）t_complaint_delay
	public final static String REPLY_STATUS_DEFAULT = "0";
	public final static String REPLY_STATUS_AGREE = "1";
	public final static String REPLY_STATUS_DISAGREE = "2";

	// 审核状态(0：默认 1：通过，2：不通过) t_complaint_flow
	public final static String CHECK_STATUS_DEFAULT = "0";
	public final static String CHECK_STATUS_AGREE = "1";
	public final static String CHECK_STATUS_DISAGREE = "2";
	
	
	@SuppressWarnings("serial")
	public final static Map<String,String> complainTypeMap = new HashMap<String,String>(){{
		put("1", "咨询");
		put("2", "投诉");
		put("3", "建议");
		put("4", "救援");
		put("5", "其他");
	}};
	@SuppressWarnings("serial")
	public final static Map<String,String> complainLevelMap = new HashMap<String,String>(){{
		put("0", "一般");
		put("1", "重大");
	}};
	@SuppressWarnings("serial")
	public final static Map<String,String> complainStatusMap = new HashMap<String,String>(){{
		put("0", "未处理");
		put("1", "处理中");
		put("2", "待回访");
		put("3", "申请关闭");
		put("4", "已关闭");
	}};

}
