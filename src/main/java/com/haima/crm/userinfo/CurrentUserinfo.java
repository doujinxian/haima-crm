package com.haima.crm.userinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haima.crm.constants.CommonConstants;
import com.haima.crm.utils.HttpUtil;

/**
 * Created by jige0727 on 2017/3/15.
 */
@Component
@Scope("session")
public class CurrentUserinfo {
	private Integer id;
	private String username;
	private String realname;

	/**
	 * 返回经销商的信息
	 * 
	 * @return
	 */
	public DealerInfo getDealerInfo() {
		JSONObject userinfo_ex = get_userinfo_ex();
		if (userinfo_ex == null) {
			return null;
		}
		DealerInfo info = new DealerInfo();
		info.setDealerId(userinfo_ex.getJSONObject("deptinfo").getLong(
				"dept_id"));
		info.setDealerName(userinfo_ex.getJSONObject("deptinfo").getString(
				"dept_name"));
		Integer deptType = userinfo_ex.getJSONObject("deptinfo").getInteger(
				"dept_type");
		if (deptType == 0) {
			info.setDealerType("1");
		}
		if (deptType == 1) {
			info.setDealerType("2");
		}
		return info;
	}

	/**
	 * 返回角色信息
	 * 
	 * @return
	 */
	public List<RoleInfo> getRolesInfo() {
		JSONObject userinfo_ex = get_userinfo_ex();
		if (userinfo_ex == null) {
			return null;
		}
		List<RoleInfo> roles = new ArrayList<>();
		JSONArray roleList = userinfo_ex.getJSONArray("roleList");
		for (int i = 0; i < roleList.size(); i++) {
			JSONObject roleJson = roleList.getJSONObject(i);
			roles.add(new RoleInfo(roleJson));
		}
		return roles;
	}

	/**
	 * 调用接口 获取用户的额外信息
	 * 
	 * @return
	 */
	private JSONObject get_userinfo_ex() {
		Map<String, String> params = new HashMap<>();
		params.put("act", "get_userinfo_ex");
		params.put("ticket", CommonConstants.UMS_TICKET);
		params.put("username", username);

		JSONObject userinfo_ex = null;
		try {
			String res = HttpUtil.sendHttpPost(CommonConstants.UMS_OUT_URL,
					params);
			LoggerFactory.getLogger(getClass()).info("res -> " + res);
			userinfo_ex = JSONObject.parseObject(res);
		} catch (Exception e) {
			LoggerFactory.getLogger(getClass()).info("error -> ", e);
		}
		return userinfo_ex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
