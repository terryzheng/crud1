package com.crud.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	private static String userName = "root";
	private static String passWord = "root";
	private static String url = "127.0.0.1";
	private static String port = "3306";
	private static String tableName = "test";

	public static void setUserName(String userName) {
		DataBase.userName = userName;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setPassWord(String passWord) {
		DataBase.passWord = passWord;
	}

	public static String getPassWord() {
		return passWord;
	}

	public static void setUrl(String url) {
		DataBase.url = url;
	}

	public static String getUrl() {
		return url;
	}

	public static void setPort(String port) {
		DataBase.port = port;
	}

	public static String getPort() {
		return port;
	}

	public static void setTableName(String tableName) {
		DataBase.tableName = tableName;
	}

	public static String getTableName() {
		return tableName;
	}

	public static Connection getCon() {
		Connection con = null;
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
			return con;
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://" + url + ":"
					+ port + "/" + tableName, userName, passWord);
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
			return con;
		}

		return con;
	}

}
