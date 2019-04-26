<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>b</title>
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
    b page<br>
   <a href="c.jsp">TO c PAGE</a>
   <!-- 
   通过a.jsp转发到b.jsp，再通过b.jsp的超链接到c.jsp
   这样写相对路径，浏览器会误以为是“ /Dive/c.jsp”(以为是相对于a.jsp的)，而不是“/Dive/jspDir/c.jsp”,
  最好如下写为绝对路径。
    -->
    
    <a href="<%= request.getContextPath() %>/jspDir/d.jsp">TO d PAGE</a>
    
    <!-- 同理，重定向也最好写成绝对路径(前面带/) -->
    <br/>
    <%//response.sendRedirect(request.getContextPath() + "/jspDir/d.jsp"); %>
    
    
  </body>
</html>
