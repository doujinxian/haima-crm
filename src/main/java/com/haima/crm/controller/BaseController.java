package com.haima.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.haima.crm.userinfo.CurrentUserinfo;

/**
 * controller的基类，可以获取用户的基本
 * 
 * @author doujinxian
 * 
 */
@Controller
public class BaseController {
	private HttpServletRequest request;
	private HttpServletResponse response;

	private static ThreadLocal<CurrentUserinfo> threadLocal = new ThreadLocal<CurrentUserinfo>();

	/**
	 * 获取当前登录的用户信息
	 * 
	 * @return
	 */
	public CurrentUserinfo getUserInfo() {
		return (CurrentUserinfo) threadLocal.get();
	}
	
	public String getUsername(){
		return getUserInfo().getUsername();
	}
	public void setUserInfo(CurrentUserinfo session) {
		threadLocal.set(session);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}