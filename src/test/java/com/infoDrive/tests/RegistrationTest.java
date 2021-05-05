package com.infoDrive.tests;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.infodrive.pageobjects.LoginPageObject;
import com.utilities.DataReader;
import com.utilities.UtilityMethods;

public class RegistrationTest {
	@DataProvider(name ="mymethod" )
public Object[][] myMethod() throws IOException
{
		
		Object[][] data= DataReader.propertyFileReader("Data.properties");
	return data;
		
}

	@BeforeTest

	public void launch() throws IOException {
		UtilityMethods.launchtheURL();
		
	}
	
	
@Test(dataProvider = "mymethod")
public void registration(String username ,String password)
{
boolean status=	LoginPageObject.doRegistration(username,password);
if (status) {
	System.out.println("The user has been successfully created");
	AssertJUnit.assertTrue(true);
} else {
	System.out.println("Failed !!!!");
	AssertJUnit.assertTrue(false);
}
}
@AfterTest
public void doAfterTest() {
	LoginPageObject.LogoutFromApplication();
}
	
}
