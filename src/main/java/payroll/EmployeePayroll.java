package payroll;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

public class EmployeePayroll {
	// Connection connection; //database connection
	public String connectToDatabase(String url, String userName, String password) {
		Connection connection; // database connection
		String connectionString = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("No drivers loaded ", e);
		}
		try {
			System.out.println("Connectin to " + url);
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println(connection);
			connectionString = connection.toString();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return connectionString;
	}

	public ArrayList<String> listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		ArrayList<String> listOfDrivers = new ArrayList<String>();
		while (driverList.hasMoreElements()) {
			Driver driver = (Driver) driverList.nextElement();
			System.out.println("  " + driver.getClass().getName());
			listOfDrivers.add(driver.getClass().getName());
		}
		return listOfDrivers;
	}

	/**
	 * Main method for manipulation odf JDBC
	 * 
	 * @param args - Default Java param (Not used)
	 */
	public static void main(String Args[]) {
		System.out.println("Welcome to payroll service");

		/**
		 * The connection URL for the mysql database is
		 * jdbc:mysql://localhost:3306/payroll_service where jdbc is the API, mysql is
		 * the database, localhost is the server name on which mysql is running, we may
		 * also use IP address, 3306 is the port number and payroll_service is the
		 * database name.
		 */
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services?allowPublicKeyRetrieval=true&useSSL=false";
		/**
		 * The default username for the mysql database is root.
		 */
		String userName = "root";
		/**
		 * It is the password given by the user at the time of installing the mysql
		 * database
		 */
		String password = "";
		EmployeePayroll employeePayRollService = new EmployeePayroll();
		employeePayRollService.connectToDatabase(jdbcURL, userName, password);
		employeePayRollService.listDrivers();
	}

}
