package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
	
	@FindBy(xpath="//img[@class='oxd-userdropdown-img']")
	 WebElement dropdownbtn;
    @FindBy(xpath="//a[text()='Logout']") 
     WebElement logoutbtn;
    
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    
    
   
	public void logout() throws InterruptedException  {
		
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       dropdownbtn.click();
       Thread.sleep(2000);
		logoutbtn.click();
		System.out.println("Logged Out Successfully!!!");
		
	}

	 protected void waitForElementToBeVisible(WebElement logoutbtn) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 10-second wait
		    wait.until(ExpectedConditions.visibilityOfElementLocated((By) logoutbtn));
	 }


	public boolean isDashboardDisplayed() 
	{                                         
		return true;
	}
}

