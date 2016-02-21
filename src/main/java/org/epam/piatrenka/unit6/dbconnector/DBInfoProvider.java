package org.epam.piatrenka.unit6.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInfoProvider {

	String login;
	String password;
	String url;

	private void registerDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Verify database");
		}
	}

	public String getLoginFromDB() throws SQLException {

		registerDriver();
		Connection conn = DriverManager.getConnection(url);
		PreparedStatement getLogin = conn.prepareStatement("SELECT login FROM creds");
		ResultSet rs = getLogin.executeQuery();
		String login = rs.getString("LOGIN");
		conn.close();
		return login;

	}

	public String getPasswordFromDB() throws SQLException {
		registerDriver();
		Connection conn = DriverManager.getConnection(url);
		PreparedStatement getPassword = conn.prepareStatement("SELECT password FROM creds");
		ResultSet rs = getPassword.executeQuery();
		String password = rs.getString("PASSWORD");
		conn.close();
		return password;
	}
}
