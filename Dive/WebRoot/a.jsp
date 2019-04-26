<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%--  <base href="<%=basePath%>"> --%>
    
    <title>a</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    a page. <br>
<% 
		//1. 请求转发的代码:
		//request.getRequestDispatcher("jspDir/b.jsp").forward(request, response);
	    //request.getRequestDispatcher("http://www.douban.com").forward(request, response);
	
	
		//2. 请求的重定向
		//response.sendRedirect("/c.jsp");
		//response.sendRedirect("http://www.douban.com");
	%>
	
	<%--请求转发forward标签写法--%>
	<jsp:forward page="jspDir/b.jsp"></jsp:forward>
  </body>
</html>
