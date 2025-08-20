package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import PageObjects.loginPage;

import utils.JsonFileManager;

public class loginTests extends testBase {
	private static JSONObject testData = JsonFileManager.readJsonFile("src//test//java//testData//data.json");

	String userName =JsonFileManager.getJsonValue(testData,"userName");
	String correctPassword =JsonFileManager.getJsonValue(testData,"correctPassword");
	String inCorrectPassword =JsonFileManager.getJsonValue(testData,"inCorrectPassword");
	loginPage loginPageObject;

@Test

public void loginWithValidData() throws InterruptedException {
	loginPageObject=new loginPage(driver);
	loginPageObject.navigateToLoginPage().login(userName, correctPassword,loginPageObject.deviceVerificationHeader);
	Assert.assertTrue(driver.findElement(loginPageObject.deviceVerificationHeader).isDisplayed());

	
}
@Test
public void loginWithInvalidData() throws InterruptedException {
	loginPageObject=new loginPage(driver);
	loginPageObject.navigateToLoginPage().login(userName, inCorrectPassword,loginPageObject.alert);
	Assert.assertTrue(driver.findElement(loginPageObject.alert).isDisplayed());
	Assert.assertEquals(driver.findElement(loginPageObject.alert).getText().trim(), "Incorrect username or password.");
}
}
