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
A1Servlet's constructor
init……
account:cashew
password:cashew123
author:cyan
author……cyan
date……1314
E:\apache-tomcat-7.0.85\webapps\Dive\README.md
Dive
/Dive
E:\apache-tomcat-7.0.85\webapps\Dive\WEB-INF\lib
service……
重复调用，只会调用service
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
		// 每个web应用程序都有一个ServletContext对象，web应用程序里，每一个servlet都共享一个ServletContext对象

		ServletContext servletContext = servletConfig.getServletContext();
		
		String author = servletContext.getInitParameter("author");
		System.out.println("author:" + author);
		
		Enumeration<String> params = servletContext.getInitParameterNames();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println(name + "……" + value); 
		}
		
		
		/**
		 * ServletContext参数
		 */
		System.out.println(servletContext.getRealPath("/README.md"));//发布、部署后在服务器上的路径 E:\apache-tomcat-7.0.85\webapps\Dive\README.md
		System.out.println(servletContext.getServletContextName());// Dive，即配置文件里display-name节点里的内容
		System.out.println(servletContext.getContextPath());//获取当前Web应用（项目）的根目录（WebContent）  /Dive
		
		String picPath = servletContext.getRealPath("/WEB-INF/lib");
		System.out.println(picPath);
		
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
		System.out.println("service……");
		
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
	
	public A1Servlet(){
		System.out.println("A1Servlet's constructor");
	}

}
