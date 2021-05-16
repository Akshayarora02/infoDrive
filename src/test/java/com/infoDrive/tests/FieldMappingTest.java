package com.infoDrive.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;

import javax.management.DescriptorKey;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.infodrive.pageobjects.ConfigurationsPageObject;
import com.infodrive.pageobjects.FieldMappingPageObject;
import com.infodrive.pageobjects.LoginPageObject;
import com.infodrive.pageobjects.ValidationPageObject;
import com.utilities.BaseTest;
import com.utilities.UtilityMethods;

public class FieldMappingTest extends BaseTest {

	@BeforeTest

	public void launch() throws IOException {
		UtilityMethods.launchtheURL();
		UtilityMethods.login();
	}

@Test
public void test1(ITestContext context) throws IOException, InterruptedException
{
	FieldMappingPageObject.navigateToFieldMapping();
String groupName=	ConfigurationsPageObject.createGroup("FieldMapping.properties");
	FieldMappingPageObject.creatingFieldMappingAndVerifying();
	ConfigurationsPageObject.listGroupsAndVerify(groupName);
	context.setAttribute("groupName", groupName);
}

@Test(dependsOnMethods = "test1")
public void editGroup(ITestContext context) throws InterruptedException
{
String groupName=(String) context.getAttribute("groupName");
groupName=ConfigurationsPageObject.editFunctionality(groupName);
context.setAttribute("groupName", groupName);

}
@Test(dependsOnMethods = "editGroup")
public void deleteGroup(ITestContext context) throws InterruptedException
{
	String groupName=(String) context.getAttribute("groupName");
	ConfigurationsPageObject.deleteFunctionality(groupName);
}
	@AfterSuite
	public void doAfterTest() {
		LoginPageObject.LogoutFromApplication();
	}

}
