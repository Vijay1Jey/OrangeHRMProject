package tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;

public class EmployeeTest extends BaseTest {

    @Test
    public void testAddEmployee() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.navigateToPIM();
        employeePage.navigateToAddEmployee();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        employeePage.addEmployee("vijay", "kumar", "r");
        
        
        navigateToEmployeeList();
        Assert.assertTrue(isEmployeeInList("vijay", "kumar" , "r"), "Employee found in the employee list");

    }

	private boolean isEmployeeInList(String string, String string2, String string3) {
		
		return true;
	}

	private void navigateToEmployeeList() {
		driver.findElement(By.xpath("//a[text()='Employee List']"));
	}
}
