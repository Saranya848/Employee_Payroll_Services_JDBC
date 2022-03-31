package payroll;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class EmployeePayrollTest {

	EmployeePayroll EmployeePayroll = new EmployeePayroll();

	@Test
	void whenInitlializedProgramWeShouldBeAbleToLoadSqlDriverClass() {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services?useSSL=false";
		String userName = "root";
		String password = "Addtexthere25";
		Connection result = EmployeePayroll.connectToDatabase(jdbcURL, userName, password);
		Assertions.assertEquals("com.mysql.jdbc.JDBC4Connection@34251ec", result);
	}

	@Test
	void whenJdbcDriverClassIsLoadedWeShouldBeAbleToObtainListOfDrivers() {
		ArrayList<String> listOfDriversTest = new ArrayList<>();
		listOfDriversTest.add("com.mysql.jdbc.Driver");
		listOfDriversTest.add("com.mysql.fabric.jdbc.FabricMySQLDriver");
		Assertions.assertEquals(listOfDriversTest, EmployeePayroll.listDrivers());
	}

	@Test
	void givenDataBaseTableWeShouldBeAbleToReadAllTheRecords() {
		String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll_service?allowPublicKeyRetrieval=true&useSSL=false";
		String userName = "root";
		String password = "Addtexthere25";
		ArrayList<EmployeePayroll> result = EmployeePayroll.readData(jdbcURL, userName, password);
		Assertions.assertEquals(3, result.size());
	}
}
