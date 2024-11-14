package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utils.TestData;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void testLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(driver);
        boolean isDashboardDisplayed = dashboardPage.isDashboardDisplayed();

        if (username.equals("Admin") && password.equals("admin123")) {
            assertTrue(isDashboardDisplayed, "Dashboard should be displayed for valid credentials.");
        } else {
            assertTrue(!isDashboardDisplayed, "Dashboard should not be displayed for invalid credentials.");
        }
    }

}
