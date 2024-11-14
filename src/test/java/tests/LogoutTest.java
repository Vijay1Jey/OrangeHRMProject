package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() throws InterruptedException  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        dashboardPage.logout();

        Assert.assertTrue(new LoginPage(driver).isLoginButtonDisplayed());
        
    }
    
    
}