package com.cashew.MyGenericServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.cashew.utils.JdbcUtil;
import com.cashew.utils.PropertiesUtil;

/**
 * 继承自 GenericServlet. 针对于 HTTP 协议所定制.
 * 调用了重载的 service(HttpServletRequest, HttpServletResponse),获取了请求方式: request.getMethod(). 根据请求方式有创建了
doXxx() 方法(xxx 为具体的请求方式, 比如 doGet, doPost)
 * 实际开发中, 直接继承 HttpServlet, 并根据请求方式复写 doXxx() 方法即可.
 * 直接由针对性的覆盖 doXxx() 方法; 直接使用 HttpServletRequest 和  HttpServletResponse, 不再需要强转.
 */
@SuppressWarnings("serial")
public class B1ServletHttp extends HttpServlet{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameter("name"));
//		super.doGet(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String c = req.getParameter("Cid");//1
		String t = req.getParameter("Tid");//2
		log.debug("Cid : " + c + " , Tid : " +t);
		
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			String url = PropertiesUtil.readValue("mysql.db");
			String user = PropertiesUtil.readValue("mysql.userName");
			String pass = PropertiesUtil.readValue("mysql.password");
			String sql = "SELECT Cname FROM course WHERE Cid = ? " +
					"AND Tid = ?";
			ps = JdbcUtil.getPreparedStatement(url, user, pass, sql);
			
			ps.setInt(1, Integer.valueOf(c));
			ps.setInt(2, Integer.valueOf(t));
			resultSet = JdbcUtil.getResultSet(ps);	
			
			StringBuilder result = new StringBuilder();
			
			if(resultSet.next()){
				String subName = resultSet.getString(1);
				
				if(subName != null){
					result.append("<html>")
					.append(" <head>")
					.append(" </head>") 
					.append(" <body>")
					.append(subName)
					.append(" </body>")
					.append("</html>");
					out.print(result.toString());
					
				}else{
					out.print("Sorry! ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(resultSet);
			JdbcUtil.close(ps);
		}
		
	}
}
