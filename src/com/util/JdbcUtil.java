package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	public static void close(ResultSet rs) {	// ResultSet에 대한 자원 반환
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		}
	}

	public static void close(Statement stmt) {	// Ststement에 대한 자원 반환
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
			}
		}
	}

	public static void close(Connection conn) {	// Connection에 대한 자원 반환
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
	}

	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
			}
		}
	}
}