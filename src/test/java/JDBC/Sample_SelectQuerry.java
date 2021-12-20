package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_SelectQuerry {

	public static void main(String[] args) throws Throwable  {
		Connection connection=null;
		try {
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from student;");
			while(result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			}
		}
			catch(Exception e) {}
			finally {
				connection.close();
				System.out.println("database is closed");
			}
	}
}
