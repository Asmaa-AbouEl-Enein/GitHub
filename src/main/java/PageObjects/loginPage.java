package PageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementActions;
import utils.PropertiesReader;

public class loginPage {
	private WebDriver driver;
	
	private By userNameField= By.id("login_field");
	private By passwordField= By.id("password");
	private By signUpButton= By.name("commit");
	public By alert =By.xpath("//div[@role='alert']");
	public By deviceVerificationHeader=By.xpath("//h1[contains(.,'Device verification')]");

	

	Properties prop;
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		prop=PropertiesReader.getProperties();
	}
	
	public loginPage navigateToLoginPage()
	{
		driver.get(prop.getProperty("url"));
		return this;
	}
	public void login(String userName,String password ,By assertion) throws InterruptedException
	{
		ElementActions.type(driver, this.userNameField, userName);
		ElementActions.type(driver, this.passwordField, password);
		ElementActions.clickElement(driver, signUpButton);
		ElementActions.commonWait(driver, assertion);
	}
	
}
