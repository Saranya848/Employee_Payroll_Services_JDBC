package payroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollTest {
    EmployeePayroll employeePayRollService = new EmployeePayroll();

    @Test
    void whenInitlializedProgramWeShouldBeAbleToLoadSqlDriverClass() {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services?useSSL=false";
        String userName = "root";
        String password = "";
        String result = employeePayRollService.connectToDatabase(jdbcURL, userName, password);
        Assert.assertEquals("com.mysql.jdbc.JDBC4Connection@34251ec", result);
    }


    @Test
    void whenJdbcDriverClassIsLoadedWeShouldBeAbleToObtainListOfDrivers() {
        ArrayList<String> listOfDriversTest = new ArrayList<String>();
        listOfDriversTest.add("com.mysql.jdbc.Driver");
        listOfDriversTest.add("com.mysql.fabric.jdbc.FabricMySQLDriver");
        Assert.assertEquals(listOfDriversTest, employeePayRollService.listDrivers());
    }
}
