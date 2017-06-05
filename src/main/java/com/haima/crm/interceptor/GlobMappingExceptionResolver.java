package com.haima.crm.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.haima.crm.utils.Result;

public class GlobMappingExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		try {
			PrintWriter writer = response.getWriter();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writer.write(JSON.toJSONString(Result.error()));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
}
