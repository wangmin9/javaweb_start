package com.cashew.servlet.httpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class C1HttpServletTargetTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("C1HttpServletTargetTest doGet 方法. ");
		//是获取不到的
		System.out.println("C1HttpServletTargetTest name: " + request.getAttribute("name"));
		
	}
}
