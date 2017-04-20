package com.haima.crm.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.haima.crm.common.AppContextHelper;
import com.haima.crm.userinfo.CurrentUserinfo;

/**
 * Created by jige0727 on 2017/3/24.
 * token方式的授权登录
 */
public class CasToolsByToken {
    public static CurrentUserinfo getCurrentUserinfo(HttpServletRequest httpServletRequest) throws Exception {
        String access_token = httpServletRequest.getHeader("access_token");

        if (access_token == null || access_token.isEmpty()) {
            return null;
        }

        Map<String, String> params = new HashMap<>();
        params.put("access_token", access_token);
        String res = HttpUtil.sendHttpPost("https://ums.tongter.com:8443/cas/oauth2.0/profile", params);
        JSONObject userJson = JSONObject.parseObject(res);
        if (userJson.containsKey("error")) {
            return null;
        }

        CurrentUserinfo userinfo = AppContextHelper.appContext.getBean(CurrentUserinfo.class);
        userinfo.setId(userJson.getJSONObject("attributes").getInteger("uid"));
        userinfo.setUsername(userJson.getJSONObject("attributes").getString("username"));
        userinfo.setRealname(userJson.getJSONObject("attributes").getString("realname"));

        return userinfo;
    }
}
