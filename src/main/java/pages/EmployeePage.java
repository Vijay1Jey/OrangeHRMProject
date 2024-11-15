package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage extends BasePage {

	@FindBy(xpath="//span[text()='PIM']")
	private WebElement PIM;

	@FindBy(xpath ="//a[text()='Add Employee']")
	private WebElement addEmployeeButton;

	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstNameField;

	@FindBy(xpath="//input[@name='middleName']")
	private WebElement middleNameField;

	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastNameField;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;

	public EmployeePage(WebDriver driver) {
		super(driver);
	}

	public void navigateToPIM()
	{
		PIM.click();
	}

	public void navigateToAddEmployee() {
		addEmployeeButton.click();
	}

	public void addEmployee(String firstName, String middleName, String lastName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName); 
		lastNameField.sendKeys(lastName);
		Thread.sleep(2000);
    	saveButton.click();
    	System.out.println("Employee added successfully");

	}

}

