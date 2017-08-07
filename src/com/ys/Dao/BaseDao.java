package com.ys.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@192.168.1.9:1521:orcl";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "12345";

	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	/**
	 * 取得数据库连接
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// 动态的加载驱动
		Class.forName(DRIVER_NAME);
		// 创建连接(1:url,2:用户名,3:密码)
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	/**
	 * 释放资源
	 * @param conn 连接
	 * @param ps 操作对象
	 * @param rs 结果集合
	 * @throws SQLException
	 */
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
