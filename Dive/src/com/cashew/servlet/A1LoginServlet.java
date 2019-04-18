package com.cashew.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
/**
 * 简单接受请求并响应
 * request获取参数
 * 
 http://localhost:8080/Dive/login?account=tonni&password=kroos&interesting=[ft,ft1]
[2019-04-18 23:36:51.146][ INFO] [ALoginServlet.java 53] || requesting…… 
[2019-04-18 23:36:51.147][DEBUG] [ALoginServlet.java 56] || tonni, kroos 
[2019-04-18 23:36:51.147][ INFO] [ALoginServlet.java 59] || interesting: [ft,ft1] 
-->[ft,ft1]
[2019-04-18 23:36:51.148][ INFO] [ALoginServlet.java 70] || account的值是 tonni 
[2019-04-18 23:36:51.151][ INFO] [ALoginServlet.java 70] || password的值是 kroos 
[2019-04-18 23:36:51.152][ INFO] [ALoginServlet.java 70] || interesting的值是 [ft,ft1] 
[2019-04-18 23:36:51.152][ INFO] [ALoginServlet.java 75] || account的值为 [tonni] 
[2019-04-18 23:36:51.152][ INFO] [ALoginServlet.java 75] || password的值为 [kroos] 
[2019-04-18 23:36:51.153][ INFO] [ALoginServlet.java 75] || interesting的值为 [[ft,ft1]] 

 */
public class A1LoginServlet implements Servlet{
//	Log log = LogFactory.getLog(this.getClass());
	Logger log = Logger.getLogger(this.getClass());
	
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
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse arg1)
			throws ServletException, IOException {
		log.info("requesting……");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		log.debug(account + ", " + password);
		
		String interesting = request.getParameter("interesting");
		log.info("interesting: " + interesting);
		
		String [] interestings = request.getParameterValues("interesting");
		for(String interest: interestings){
			System.out.println("-->" + interest);
		}
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String name =  parameterNames.nextElement();
			String value =   request.getParameter(name);
			log.info(name + "的值是 " + value);
		}
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			log.info(entry.getKey() + "的值为 " + Arrays.asList(entry.getValue()));
		}
	}

}
