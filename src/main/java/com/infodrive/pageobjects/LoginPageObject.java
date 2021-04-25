package com.infodrive.pageobjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.utilities.UtilityMethods.*;

import com.utilities.BaseTest;
import com.utilities.DataReader;

public class LoginPageObject extends BaseTest {

	public LoginPageObject(WebDriver dr)
	{
		dr=BaseTest.driver;
		PageFactory.initElements(dr, LoginPageObject.class);
	}

public static By usernameTextField=By.xpath("//input[@type='email']");

public static By passwordTextField=By.xpath("//input[@type='password']");

public static By loginButton=By.xpath("//button[text()='Sign in']");

public static By logoutButton =By.xpath("(//p//i)[5]//..//..//..//following-sibling::ul//li//span[text()='Log Out']");
public static void LoginToApplication() throws IOException
{
	HashMap<String,String > map =DataReader.credentialsReader();
	String username="";
	String password="";
	for ( Map.Entry<String, String> entry : map.entrySet()) {
	     username = entry.getKey();
	     password = entry.getValue();
	 
	}
	String url=driver.getCurrentUrl();
	enterDataInTextBox(usernameTextField, driver, username);
	enterDataInTextBox(passwordTextField, driver, password);
	takeScreenshot();
	clickOnTheElement(loginButton, driver);


}
public static void LogoutFromApplication()
{
	Actions a =new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("(//p//i)[5]"))).perform();
	clickOnTheElement(logoutButton, driver);
	driver.close();
}

}
