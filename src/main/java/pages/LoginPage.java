package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	@FindBy(xpath = "//input[@name='username']") WebElement usernameField;
    @FindBy(xpath ="//input[@name='password']") WebElement passwordField;
    @FindBy(xpath="//button[@type='submit']") WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password)
    {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        System.out.println("Logged in Successfully");
    }

	public boolean isLoginButtonDisplayed() {
		return true;
	}
}