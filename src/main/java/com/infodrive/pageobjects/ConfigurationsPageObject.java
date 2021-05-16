package com.infodrive.pageobjects;
import static com.utilities.UtilityMethods.*;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.utilities.BaseTest;
import com.utilities.DataReader;

public class ConfigurationsPageObject extends BaseTest {
	
	
	
public static By configurationsLink =By.xpath("//span[text()='Configurations']");
public static By universalFieldsLink=By.xpath("//a[text()='Universal Fields']");
public static By validationLink=By.xpath("//a[text()='Validation']");
public static By fieldMappinLink=By.xpath("//a[text()='Field Mapping']");
public static By enrichmentLink=By.xpath("//a[text()='Enrichment']");
public static By processorLink=By.xpath("//a[text()='Processor']");
public static By jobExecutionTemplateLink =By.xpath("//a[text()='JobExecutionTemplate']");
public static By createGroups = By
.xpath(" //a[contains(text(),'Create Group')]");
public static By createGroupsXpath = By
.xpath(" (//a[contains(text(),'Create Group')])[2]");
public static String groupNametoBeFilled = "";
public static By submitButton = By.xpath(" //button[text()='Submit']");
public static By listGroup = By
.xpath(" //a[contains(text(),'List Group')] ");
public static By listGroup2=By.xpath(" (//a[contains(text(),'List Group')])[2]");
public static String editButton = " //td[text()='X']//..//td[2]//button[1]";
public static String deleteButton = "//td[text()='X']//..//td[2]//div//following-sibling::button//i";
public static By groupTextField = By.xpath(" //input[@name='group']");
public static By searchGroup = By.xpath(" //input[@placeholder='Search...']");
public static By searchBox = By.xpath("//input[@placeholder='Enter Name...']");
public static String createGroup(String fileName) throws IOException, InterruptedException {
	groupNametoBeFilled = DataReader.propertyFileReader(fileName, "groupName");
	try
	{
	clickOnTheElement(createGroups, driver);
	}
	catch(Exception e)
	{
	clickOnTheElement(createGroupsXpath, driver);
	}
	Random rand = new Random();
	int rand_int1 = rand.nextInt(1000);
	groupNametoBeFilled = groupNametoBeFilled + rand_int1;
	System.out.println("Created Group Name is : " + groupNametoBeFilled);
	enterDataInTextBox(groupTextField, driver, groupNametoBeFilled);
	takeScreenshot();
	clickOnTheElement(submitButton, driver);

	Thread.sleep(7000);
	return groupNametoBeFilled;
}
public static void listGroupsAndVerify(String groupName) throws InterruptedException {
	String finder = "//td[text()='X']";
	
	waitUntilElementVisible(listGroup, driver);
	try
	{
	clickOnTheElement(listGroup, driver);
	}
	catch(Exception e)
	{
		clickOnTheElement(listGroup2, driver);
	}
	waitUntilElementVisible(searchBox, driver);
	enterDataInTextBox(searchBox, driver, groupName + Keys.ENTER);
	Thread.sleep(3000);
	finder = finder.replace("X", groupName);

	boolean status = isElementDisplayed(finder, driver);
	Assert.assertEquals(status, true);

}
public static String editFunctionality(String groupname) throws InterruptedException {
	driver.navigate().refresh();
	Thread.sleep(5000);
	try
	{
	clickOnTheElement(listGroup, driver);
	}
	catch(Exception e)
	{
		clickOnTheElement(listGroup2, driver);
	}
	waitUntilElementVisible(searchBox, driver);
	enterDataInTextBox(searchBox, driver, groupname + Keys.ENTER);

	editButton = editButton.replace("X", groupname);
	try {
		clickOnTheElement(editButton, driver);
	} catch (Exception e) {
		System.out.println("Group Not found");
		Assert.assertTrue(false);
	}
	Random rand = new Random();
	int randomNumber = rand.nextInt(10000);
	groupname = groupname + randomNumber;
	System.out.println("updatedGroupName  is :" + groupname);
	clearTextBox(groupTextField, driver);
	enterDataInTextBox(groupTextField, driver, groupname);
	clickOnTheElement(submitButton, driver);
	Thread.sleep(3000);
	listGroupsAndVerify(groupname);
	return groupname;
}
public static void deleteFunctionality(String groupName) throws InterruptedException {

	driver.navigate().refresh();
	Thread.sleep(3000);
	try
	{
	clickOnTheElement(listGroup, driver);
	}
	catch(Exception e)
	{
		clickOnTheElement(listGroup2, driver);
	}
	waitUntilElementVisible(searchBox, driver);
	enterDataInTextBox(searchBox, driver, groupName + Keys.ENTER);
	deleteButton = deleteButton.replace("X", groupName);
	try {
		clickOnTheElement(deleteButton, driver);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	} catch (Exception e) {
		System.out.println("Element not found");
		Assert.assertTrue(false);
	}
	Thread.sleep(3000);

	String finder = "//td[text()='X']";
	waitUntilElementVisible(listGroup, driver);
	try
	{
	clickOnTheElement(listGroup, driver);
	}
	catch(Exception e)
	{
		clickOnTheElement(listGroup2, driver);
	}
	waitUntilElementVisible(searchBox, driver);
	enterDataInTextBox(searchBox, driver, groupName + Keys.ENTER);
	Thread.sleep(3000);
	finder = finder.replace("X", groupName);

	boolean status = isElementDisplayed(finder, driver);
	Assert.assertEquals(status, false);

}

}
