<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage/error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
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
    This is my JSP page. <br>
    <% 
		System.out.println("you are requsting " + basePath);
	%>
	
	<!-- 殊途同归  cr1t-->
	<a href="cr1t">toCr1t</a>
	
	<br><br>
	
	<a href="cd1">Forward</a>
	
	<br><br>
	
	<a href="cr1">Redirect</a>
	
	<!-- 产生一个404，使得到error.jsp  no!-->
	<a href="az">toCr1t</a>
	
  </body>
</html>
