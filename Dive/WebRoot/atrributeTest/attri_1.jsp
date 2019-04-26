<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>attri_1.jsp</title>
    
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
  <%--四个域对象 --%>
   <% 
		pageContext.setAttribute("pageContextAttr", "pageContextValue");
		request.setAttribute("requestAttr", "requestValue");
		session.setAttribute("sessionAttr", "sessionValue");
		application.setAttribute("applicationAttr", "applicationValue");
	%>
	
	<h2>Attr 111 Page: <%= new Date() %></h2>
	
	<br><br>
	pageContextAttr: <%= pageContext.getAttribute("pageContextAttr") %>
	
	<br><br>
	requestAttr: <%= request.getAttribute("requestAttr") %>

	<br><br>
	sessionAttr: <%= session.getAttribute("sessionAttr") %>	
	
	<br><br>
	applicationAttr: <%= application.getAttribute("applicationAttr") %>
	
	<br><br>
	<!-- 这样写访问的是 http://localhost:8080/Dive/attri_2.jsp  都是base 标签的锅
	<a href="attri_2.jsp">To Attr2 Page</a> -->
	<a href="atrributeTest/attri_2.jsp">To Attr2 Page</a>

	<br><br>
	<!-- 这样写访问的是 http://localhost:8080/cat
	<a href="../cat">To Attr Servlet</a> -->
	<a href="cat">To Attr Servlet</a>
	
	<% 
		//request.getRequestDispatcher("attri_2.jsp").forward(request, response);
	%>
		
	
  </body>
</html>
