package com.haima.crm.controller;

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
}