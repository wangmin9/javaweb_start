package com.cashew.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 测试load-on-startup   Servlet 被创建的时机
启动tomcat发现，随项目启动，被初始化
四月 18, 2018 9:27:09 下午 org.apache.catalina.util.SessionIdGeneratorBase createSecureRandom
警告: Creation of SecureRandom instance for session ID generation using [SHA1PRNG] took [239] milliseconds.
a2Servlet init...
四月 18, 2018 9:27:09 下午 org.apache.catalina.startup.HostConfi……
 */
public class A2Servlet implements Servlet{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("a2Servlet init...");
		
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("a2Servlet service……");
		
	}

}
