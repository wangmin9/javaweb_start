<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>attri_2.jsp</title>
    
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
  <%--四个域对象属性获取 --%>
 	<h2> Attr 222 Page: <%= new Date() %> </h2>
	<br><br>
	pageContextAttr: <%= pageContext.getAttribute("pageContextAttr") %>
	<br><br>
	requestAttr: <%= request.getAttribute("requestAttr") %>
	<br><br>
	sessionAttr: <%= session.getAttribute("sessionAttr") %>	
	<br><br>
	applicationAttr: <%= application.getAttribute("applicationAttr") %>
  </body>
</html>
