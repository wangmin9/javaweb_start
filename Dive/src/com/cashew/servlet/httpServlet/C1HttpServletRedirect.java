package com.cashew.servlet.httpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 */
@SuppressWarnings("serial")
public class C1HttpServletRedirect extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C1HttpServletRedirect doGet");
		
		request.setAttribute("name", "xman");
		System.out.println("RedirectServlet's name: " + request.getAttribute("name"));
		
		
		//执行请求的重定向, 直接调用 response.sendRedirect(path) 方法,
		//path 为要重定向的地址
		response.sendRedirect("cr1t");
	}
}
