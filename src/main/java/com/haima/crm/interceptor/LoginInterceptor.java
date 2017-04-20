package com.haima.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.haima.crm.userinfo.CurrentUserinfo;
import com.haima.crm.utils.CasToolsByToken;

/**
 * cas操作步骤 获取登录状态
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object o) throws Exception {
		String uri = request.getRequestURI();
		LoggerFactory.getLogger(getClass()).info("uri -> " + uri);

		CurrentUserinfo userinfo = CasToolsByToken.getCurrentUserinfo(request);
		if (userinfo == null) {
			// 返回错误401，未授权
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		return true;
	}
}
