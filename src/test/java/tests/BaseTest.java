package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeClass
    public void setUp() {
       // System.setProperty("webdriver.chrome.driver", "/OHRM/src/test/resources/Drivers/chrome.exe"); // Update the path
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        basePage = new BasePage(driver);
    }

    @BeforeMethod
    public void navigateToHomePage() {
        basePage.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Update with your application URL
    }   // Navigate to Home Page

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the Browser
        }
    }
}
