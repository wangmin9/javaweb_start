package com.cashew.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



/**
 * 通过jsp接受请求并响应
 * httpServletResponse重定向
 */
public class A4LoginRedirectServ implements Servlet{
	Logger log = Logger.getLogger(this.getClass());
	
	
	@Override
	public void destroy() {
		
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		log.debug("a4s initing……");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		log.info("requesting……");
		String pet = request.getParameter("pet");
		String [] foods = request.getParameterValues("eat");
		String age = request.getParameter("age");
		log.debug("petName：" + pet);
		log.debug("age：" + age);
		for(String food: foods){
			log.debug("-->" + food);
		}
		
	
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		//设置一个参数
		httpServletRequest.setAttribute("type","labrado");//设置request的参数值 
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
//		httpResponse.sendRedirect("index.jsp");
//		httpResponse.sendRedirect("www.douban.com");//  /Dive/www.douban.com
		httpResponse.sendRedirect("http://www.douban.com");// 这样才能重定向到别的站点
	}

}
