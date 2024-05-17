package com.arta.warehouse.dao;

import java.sql.*;

/**
 * DataBaseConnector
 */
public class DataBaseConnector {
	private static final String POSTGRES_HOST = "ep-silent-scene-a4cd772l-pooler.us-east-1.aws.neon.tech";
	private static final String PORT = "5432";
	private static final String POSTGRES_DATABASE = "verceldb";
	private static final String URL = "jdbc:postgresql://" + POSTGRES_HOST + ":" + PORT + "/"
			+ POSTGRES_DATABASE;
	private static final String USER = "default";
	private static final String PASSWD = "R89LWSkZmQXt";

	public static ResultSet get(String sqlQuery) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWD);
		Statement stmt = con.createStatement();
		return stmt.executeQuery(sqlQuery);
	}

	public static int post(String sqlQuery) throws SQLException {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWD);
				Statement stmt = con.createStatement()) {
			return stmt.executeUpdate(sqlQuery);
		}
	}

	public static PreparedStatement prepareStatement(String sqlQuery) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWD);
		return con.prepareStatement(sqlQuery);
	}

}
