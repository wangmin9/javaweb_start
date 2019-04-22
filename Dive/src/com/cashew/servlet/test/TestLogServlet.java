package com.cashew.servlet.test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**等级由低到高：debug<info<warn<Error<Fatal;
 * debug 级别最低，可以随意的使用于任何觉得有利于在调试时更详细的了解系统运行状态的东东；
info  重要，输出信息：用来反馈系统的当前状态给最终用户的；
后三个，警告、错误、严重错误，这三者应该都在系统运行时检测到了一个不正常的状态。
warn, 可修复，系统可继续运行下去；
Error, 可修复性，但无法确定系统会正常的工作下去;
Fatal, 相当严重，可以肯定这种错误已经无法修复，并且如果系统继续运行下去的话后果严重。

什么时候使用 info, warn , error ?
info 用于打印程序应该出现的正常状态信息， 便于追踪定位；
warn 表明系统出现轻微的不合理但不影响运行和使用；
error 表明出现了系统错误和异常，无法正常完成目标操作。
 */

public class TestLogServlet implements Servlet{
	//使用 class.getName() 作为新Logger的名字
	Logger logger1 = Logger.getLogger(TestLogServlet.class.getName());
	Logger logger2 = Logger.getLogger(this.getClass().getName());

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
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
	}

}
