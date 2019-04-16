package com.cashew.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 访问：http://localhost:8080/Dive/a1
init……
account:cashew
password:cashew123
servletContextName:Dive
author:cyan
author:cyan
date:1314
servicee
 */
public class A1Servlet implements Servlet{

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init……");
		
		/*
		 * 获取实例化参数
		 * 1.知道参数名的情况：servletConfig.getInitParameter("account");
		 * 2.不知道参数名的情况，如下
		 */
		Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
		while(initParameterNames.hasMoreElements()){
			String key = initParameterNames.nextElement();
			String  value = servletConfig.getInitParameter(key);
			System.out.println(key + ":" + value);
		}
		
		
		/*
		 * 获取当前 WEB 应用的初始化参数
		 * 1.知道参数名的情况：servletContext.getInitParameter("author");
		 * 2.不知道参数名的情况，如下
		 */
		ServletContext servletContext = servletConfig.getServletContext();
		String servletContextName = servletContext.getServletContextName();
		String author = servletContext.getInitParameter("author");
		System.out.println("servletContextName:" + servletContextName);
		System.out.println("author:" + author);
		
		Enumeration<String> params = servletContext.getInitParameterNames();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println(name + ":" + value); 
		}
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public void service(ServletRequest paramServletRequest,
			ServletResponse paramServletResponse) throws ServletException,
			IOException {
		System.out.println("service");
		
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}

}
