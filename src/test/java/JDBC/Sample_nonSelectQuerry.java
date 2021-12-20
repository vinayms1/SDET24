package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_nonSelectQuerry {

	public static void main(String[] args) throws Throwable {
		Connection connection = null;
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into student values(7,'VIJAY','K P','vijaykp@gmail.com')");

			if (result == 1) {
				System.out.println("data will be created");
			}

		} catch (Exception e) {

			System.err.println("data not created");

		} finally {
			connection.close();
			System.out.println("database is closed");
		}

	}

}
