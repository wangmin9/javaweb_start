package com.cashew.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	static Connection connection = null;
	
	public static ResultSet getResultSet(PreparedStatement statement) {
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	public static PreparedStatement getPreparedStatement(String url, String user, String pass, String sql){
		PreparedStatement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	} 
	
	public static void close(Object obj){
		if(obj instanceof Connection){
			try {
				Connection conn= (Connection)obj;
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(obj instanceof ResultSet){
			try {
				ResultSet res= (ResultSet)obj;
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(obj instanceof PreparedStatement){
			try {
				PreparedStatement ps= (PreparedStatement)obj;
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
