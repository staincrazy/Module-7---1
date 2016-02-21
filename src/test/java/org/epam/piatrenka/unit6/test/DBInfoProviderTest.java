package org.epam.piatrenka.unit6.test;

import java.sql.SQLException;

import org.epam.piatrenka.unit6.dbconnector.DBInfoProvider;
import org.testng.annotations.Test;

public class DBInfoProviderTest {

	@Test(description = "db test")
	public void testDb() throws SQLException {
		DBInfoProvider db = new DBInfoProvider();
		String login = db.getLoginFromDB();
		String password = db.getPasswordFromDB();
		
		System.out.println(login + password);
	}

}
