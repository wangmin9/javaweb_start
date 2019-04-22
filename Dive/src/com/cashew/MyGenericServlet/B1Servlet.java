package com.cashew.MyGenericServlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 是 Servlet 接口和 ServletConfig 接口的实现类. 但是一个抽象类. 其中的 service 方法为抽象方法,
 * 如果新建的 Servlet 程序直接继承 GenericSerlvet 会使开发更简洁.只需要重写service()方法即可。
 * 
 * ServletConfig是它的成员变量，在init(servletConfig)方法里被初始化；
	init(servletConfig)方法中，还调用了init()方法（该方法并不是Servlet生命周期相关的方法，是手动调用的）；
	建议其子类如果需要，重写init()方法实现servlet初始化，而不是重写init(servletConfig)方法，
	因为如果忘写super.init(servletConfig)，就没有为this.servletConfig赋值，要是还用了ServletConfig的方法的话，会出现空指针异常NullPointerException


public abstract class GenericServlet implements Servlet, ServletConfig {

	/** 以下方法为 Servlet 接口的方法
	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	private ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
		init();
	}

	public void init() throws ServletException{}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException;

	/** 以下方法为 ServletConfig 接口的方法 
	@Override
	public String getInitParameter(String arg0) {
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

}
 */
@SuppressWarnings("serial")
public class B1Servlet extends GenericServlet{

	@Override
	public void service(ServletRequest paramServletRequest,
			ServletResponse paramServletResponse) throws ServletException,
			IOException {
		// 获取当前 WEB 应用的初始化参数 变得简单,ServletConfig 接口的方法
		String author = getServletContext().getInitParameter("author");
		System.out.println("author:" + author);
		
	}

}
