package com.haima.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.haima.crm.controller.BaseController;
import com.haima.crm.userinfo.CurrentUserinfo;
import com.haima.crm.utils.CasToolsByToken;

/**
 * cas操作步骤 获取登录状态
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod hm = (HandlerMethod) handler;
		//每个controller都需要继承BaseController，否则这里会报错
		BaseController baseCtl = (BaseController) hm.getBean();
		
		CurrentUserinfo userinfo = CasToolsByToken.getCurrentUserinfo(request);
		if (userinfo == null) {
			// 返回错误401，未授权
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		baseCtl.setUserInfo(userinfo);
		return true;
	}
}
