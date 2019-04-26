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
public class C1HttpServletDispatcher extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C1HttpServletDispatcher doGet");
		
		request.setAttribute("name", "cman");
		System.out.println("C1HttpServletDispatcher's name: " + request.getAttribute("name"));
		
		//执行转发操作
		String path0 = "cr1t";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/" + path0);
        //进行请求的转发
        requestDispatcher.forward(request, response); 
		
	}
}
