package com.cashew.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesUtil {
	private static URL url = PropertiesUtil.class
			.getResource("/db.properties");
	ClassLoader classLoader = getClass().getClassLoader();
	

	public static String readValue(String key) {
		Properties props = new Properties();
		try {
			String u = URLDecoder.decode(url.getFile(), "utf-8");
			InputStream in = new BufferedInputStream(new FileInputStream(u));
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String readValue0(String key) {
		Properties props = new Properties();
		try {
			InputStream in = classLoader.getResourceAsStream("log4j.properties");
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		System.out.println(13 && 5);
//	}
}
