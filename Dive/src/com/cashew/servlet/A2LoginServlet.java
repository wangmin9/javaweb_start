package com.cashew.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;



/**
 * 通过jsp接受请求简单响应
 * request获取信息
 * httpServletRequest
 */
public class A2LoginServlet implements Servlet{
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
		log.debug("a2s initing……");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		log.info("requesting……");
		String account = request.getParameter("account");
		String [] accounts = request.getParameterValues("account");
		String password = request.getParameter("password");
		log.debug("account 通过getParameter只获取第一个参数：" + account);
		log.debug("account 通过getParameterValues的所有参数：" + accounts.toString());
		log.debug("password是：" + password);
		
		String [] interestings = request.getParameterValues("interesting");
		for(String interest: interestings){
			log.debug("-->" + interest);
		}
		
		/*
		 * HttpServletRequest: 是 SerlvetRequest 的子接口. 针对于 HTTP 请求所定义. 里边包含了大量获取 HTTP 请求相关的方法. 
		 */
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		//客户端信息
		log.warn("RequestURI: " + httpServletRequest.getRequestURI());// /Dive/co （站点（ip）后面的，不会带请求参数）
		log.warn("RequestURL: " + httpServletRequest.getRequestURL());// 获取发出请求字符串的客户端地址 
		log.warn("RemoteHost: " + httpServletRequest.getRemoteHost());//获取客户端名字
		log.warn("RemoteAddr: " + httpServletRequest.getRemoteAddr());//获取客户端的IP地址
		
		//服务器信息
		log.warn("ServerName: " + httpServletRequest.getServerName());//获取服务器的名字
		log.warn("ServerPort: " + httpServletRequest.getServerPort());//获取服务器的端口号 
		
		//常见的
		log.fatal("ContextPath: " + httpServletRequest.getContextPath()); //返回当前页面所在的应用的名字，同servletContext.getContextPath()
		String path = httpServletRequest.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		log.fatal("basePath：" + basePath);
		log.error("ServletPath: " + httpServletRequest.getServletPath()); // /co 获取servlet名字（映射路径）
		
		//http信息
		log.warn("getScheme: " + httpServletRequest.getScheme());//返回的是当前连接使用的协议，一般应用返回的是http、SSL返回的是https；
		log.warn("getProtocol: " + httpServletRequest.getProtocol());//获取客户端向服务器端传送数据所依据的协议名称 
		log.warn("Method: " + httpServletRequest.getMethod());//POST
		log.warn("QueryString: " + httpServletRequest.getQueryString()); // post方法是null 请求参数字符串（get方法时，？后的东西）
		
		//常用
		log.info("CharacterEncoding:"+httpServletRequest.getCharacterEncoding());//返回请求中的字符编码方式
		Cookie[] cookies = httpServletRequest.getCookies();//返回客户端的所有Cookie对象，结果是一个Cookie数组
		log.info("cookies:"+cookies);
		
		HttpSession session = httpServletRequest.getSession(false);//返回和请求相关Session 
		log.info("session:"+session);
		
		String header = httpServletRequest.getHeader("Host");//获得HTTP协议定义的文件头信息 
		log.info("Host in header： " + header);
		Enumeration<String> headers = httpServletRequest.getHeaders("Host");//返回指定名字的request Header的所有值，结果是一个枚举的实例  
		log.info("headers： " + headers);
		Enumeration<String> headerNames = httpServletRequest.getHeaderNames();//返回所有request Header的名字，结果是一个枚举的实例   
		log.info("headerNames： " + headerNames);
		
		int contentLength = httpServletRequest.getContentLength();//返回请求的Body的长度 
		log.info("contentLength： " + contentLength);
		
/*		
 * 
 * request.getAttribute():当两个web组件为转发关系时，通过getAttribute()和setAttribute()来共享request范围内的数据。attrubute中的数据是Object类型的，通过attribute传递的数据只会存在于web容器内部，仅仅是请求处理阶段。
   request.setAttribute是服务器把这个对象放在该页面对应的一块内存中，当发生服务器转发时，会把这块内存拷到另一页面对应的内存中，这样getAttribute就可以取到值，session也一样，只是对象在内存的生命周期不一样。
 
小结：request.getAttribute()方法返回request范围内存在的对象，request.getParameter()获取http请求提交过来的数据。
一般的Web应用，基本上是post方式的传递，用getParameter取值。对于自己控制的，可以通过request.setAttribute和getAttribute实现值的传递。
 
对于应用struts的，getAttribute用的多一点，其他的基本用getParameter，一个可以传对象，一个只能传字符串。
*/
//        setAttribute(String name,Object)：设置名字为name的request的参数值 
//		getAttribute(String name)：返回由name指定的属性值 
//		getAttributeNames()：返回request对象所有属性的名字集合，结果是一个枚举的实例 
//		 
//		
//		getInputStream()：返回请求的输入流，用于获得请求中的数据 
//		 
//		removeAttribute(String name)：删除请求中的一个属性 

		PrintWriter out = response.getWriter();
		out.println("helloworld...");
	}

}
