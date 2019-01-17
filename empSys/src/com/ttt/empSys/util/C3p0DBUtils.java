package com.ttt.empSys.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0DBUtils {
	private static ComboPooledDataSource source = null;
	private static Connection connection = null;
	
	/**
	 * 私有构造
	 */
	private C3p0DBUtils() {
		
	}
	
	/**
	 * 获取到数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		source = new ComboPooledDataSource();
		return source;
	}
	
	/**
	 * 获取连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnention() throws SQLException {
		connection = getDataSource().getConnection();
		if(connection != null) {
			return connection;
		} else {
			connection = getDataSource().getConnection();
		}
		return connection;
	}
	
	public static void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) {
			connection.close();
		}
			
	}
	
	
}
