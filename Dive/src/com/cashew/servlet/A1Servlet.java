package com.cashew.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * servletContext
 * 
 * 访问：http://localhost:8080/Dive/a1
A1Servlet's constructor
init……
account:cashew
password:cashew123
author:cyan
author……cyan
date……1314
E:\apache-tomcat-7.0.85\webapps\Dive\README.md
toDive
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
		 * ServletContext方法
		 */
		System.out.println(servletContext.getRealPath("/README.md"));//发布、部署后在服务器上的路径 E:\apache-tomcat-7.0.85\webapps\Dive\README.md
		System.out.println(servletContext.getServletContextName());// toDive，即配置文件里display-name节点里的内容
		System.out.println(servletContext.getContextPath());//获取当前Web应用（项目）的根目录（WebContent）  /Dive
		
		String picPath = servletContext.getRealPath("/WEB-INF/lib");
		System.out.println(picPath);
		
		//获取当前 WEB 应用的某一个文件对应的输入流.
		InputStream resourceAsStream = servletContext.getResourceAsStream("log4j.properties");// path 的 / 为当前 WEB 应用的根目录(WebContent)的path.
		//因为部署后改文件的实际位置是%tomcat_home%\webapps\Dive\WEB-INF\classes,所以应该写成如下：
		InputStream resourceAsStream2 = servletContext.getResourceAsStream("\\WEB-INF\\classes\\log4j.properties");// path 的 / 为当前 WEB 应用的根目录(WebContent)的path.
		System.out.println("resourceAsStream: "+ resourceAsStream);
		System.out.println("resourceAsStream2: "+ resourceAsStream2);
		
		//ps，另外的写法
		InputStream resourceAsStream3 = getClass().getClassLoader().getResourceAsStream("log4j.properties");
		System.out.println("resourceAsStream3: "+ resourceAsStream3);
		
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
