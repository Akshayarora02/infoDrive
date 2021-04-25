package com.infodrive.pageobjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	driver.findElement(usernameTextField).sendKeys(username);
	driver.findElement(passwordTextField).sendKeys(password);
	driver.findElement(loginButton).click();

}

}
