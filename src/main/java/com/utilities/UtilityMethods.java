package com.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.infodrive.pageobjects.LoginPageObject;

public class UtilityMethods extends BaseTest  {

	public static void launchtheURL()
	{
		driver.get("https://bluepi-server-stag-branch.dqfhn2tgn5qy1.amplifyapp.com/");
		driver.manage().window().maximize();
	}
	public static void login() throws IOException
	{
		LoginPageObject.LoginToApplication();
	}
}
