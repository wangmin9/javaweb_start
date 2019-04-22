package com.cashew.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;



/**
 * 通过jsp接受请求并响应
 * response响应信息
 */
public class A3LoginServlet implements Servlet{
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
		log.debug("a3s initing……");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		log.info("requesting……");
		String team = request.getParameter("Team");
		String [] hated = request.getParameterValues("hated");
		String partner = request.getParameter("Partner");
		log.debug("team：" + team);
		log.debug("partner：" + partner);
		log.debug("enemies：" + hated.toString());
		
	
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//常见的
		String path = httpServletRequest.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		log.fatal("basePath：" + basePath);
		
		
		/*
		 * 设置响应的内容类型，这里返回一个word
		 * tomcat的cong/web.xml里，搜索word，即可知道参数里面怎么写了
		 * 之后再请求该servlet，会自动下载一个word，内容是helloworld…
		 */
		response.setContentType("application/msword");
		PrintWriter out = response.getWriter();
		out.println("helloworld...");//默认会打印到浏览器上
	}

}
