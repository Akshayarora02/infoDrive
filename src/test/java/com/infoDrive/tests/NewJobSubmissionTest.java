package com.infoDrive.tests;
import java.io.IOException;

import javax.swing.text.Utilities;

import org.testng.annotations.*;

import com.infodrive.pageobjects.LoginPageObject;
import com.infodrive.pageobjects.NewJobSubmission;
import com.utilities.BaseTest;
import com.utilities.UtilityMethods;
public class NewJobSubmissionTest extends BaseTest{

@BeforeTest
	
	public void launch() throws IOException
	{
	UtilityMethods.launchtheURL();
	UtilityMethods.login();
	}

@Test
public void newJobSubmissionTest() throws IOException, InterruptedException
{
	NewJobSubmission.doSearch();
}


@AfterTest
public void doAfterTest()
{
	LoginPageObject.LogoutFromApplication();
}

}
