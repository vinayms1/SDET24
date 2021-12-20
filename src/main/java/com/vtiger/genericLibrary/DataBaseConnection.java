package com.vtiger.genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnection {
	Connection connection = null;
	Statement statement = null;

	@Test
	public void getConnection() throws Throwable {
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		} catch (Exception e) {
		}
	}

	@Test
	public void createStatement() throws Throwable {
		try {
			statement = connection.createStatement();
		} catch (Exception e) {
		}
	}

	@Test
	public void getResult() throws Throwable {
		try {
			ResultSet result = statement.executeQuery("select * from student;");

			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
						+ result.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void databaseClose() throws Throwable {
		connection.close();
	}
}
