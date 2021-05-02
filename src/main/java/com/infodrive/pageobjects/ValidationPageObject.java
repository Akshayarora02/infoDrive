package com.infodrive.pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.utilities.BaseTest;
import com.utilities.DataReader;
import static com.utilities.UtilityMethods.*;

public class ValidationPageObject extends BaseTest {

	public static By validationLink = By.xpath(" //a[text()='Validation']");
	public static By list_validation = By.xpath(" //a[text()='List' and contains(@href,'validation')]");
	public static By createValidation = By.xpath("//a[contains(text(),'Create Validation')]");
	public static By createGroupValidation = By
			.xpath(" //a[contains(text(),'Create Group') and contains(@href,'validation')]");
	public static By listGroupValidation = By
			.xpath(" //a[contains(text(),'List Group') and contains(@href,'validation')]");
	public static String editButton = " //td[contains(text(),'X')]//..//td[@class='edit_remove_btton']//a//button//i";
	public static String deleteButton = " //td[contains(text(),'X')]//..//td[@class='edit_remove_btton']//a//following-sibling::button//i";
	public static By validationTextField = By.xpath(" //input[@name='validation']");
	public static By typeDropDown = By.xpath(" //select[@name='type']");
	public static By combinatorsDropDown = By.xpath(" //select[@title='Combinators']");
	public static By addRuleButton = By.xpath(" //button[@title='Add rule']");
	public static By saveButton = By.xpath(" //button[text()='Save']");
	public static By fieldsdropdown = By.xpath(" //select[@title='Fields']");
	public static By operatorsdropdown = By.xpath(" //select[@title='Operators']");
	public static By valueTextField = By.xpath(" //input[@title='Value']");
	public static By removeRule = By.xpath(" //button[@title='Remove rule']");
	public static By groupTextField = By.xpath(" //input[@name='group']");
	public static By searchGroup = By.xpath(" //input[@placeholder='Search...']");
	public static By selectAllcheckbox = By.xpath(" //input[@type='checkbox'][1]");
	public static By submitButton = By.xpath(" //button[text()='Submit']");
	public static By pagination = By.xpath(" //a[@class='page-link']");
	public static By paginationNext = By.xpath(" //a[@class='page-link' and @aria-label='Next']");
	public static By listPageNext = By.xpath("//a[@class='page-link' and @aria-label='Next']//..");

	public static String groupNametoBeFilled = "";
	final String[] validationLinks = { "List", "Create Validation", "Create Group", "List Group" };
	public static String verificationGroupcreated = "//td[text()='X']";
	public static String finder = "//td[text()='X']";
	public static By returnContentsPresentInPage = By
			.xpath("//table[@class='overflow-hidden table']//tbody//tr//td[1]");
	public static By pageNumber1 = By.xpath("//a[text()='1']");
	public static By returnContentsPresentInPage1 = By
			.xpath("//table[@class='overflow-hidden table']//tbody//tr//td[2]");
	

	public static boolean createGroup() throws IOException, InterruptedException {
		groupNametoBeFilled = DataReader.propertyFileReader("validationData.properties", "groupName");
		waitUntilElementVisible(ConfigurationsPageObject.configurationsLink, driver);
		clickOnTheElement(ConfigurationsPageObject.configurationsLink, driver);
		clickOnTheElement(validationLink, driver);
		clickOnTheElement(createGroupValidation, driver);
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		groupNametoBeFilled = groupNametoBeFilled + rand_int1;
		System.out.println("Created Group Name is : " + groupNametoBeFilled);
		enterDataInTextBox(groupTextField, driver, groupNametoBeFilled);
		takeScreenshot();
		clickOnTheElement(submitButton, driver);
		Thread.sleep(3000);
		clickOnTheElement(listGroupValidation, driver);
		verificationGroupcreated = verificationGroupcreated.replace("X", groupNametoBeFilled);
		boolean stop = false;
		scrollDownUntilElementVisible(By.xpath(verificationGroupcreated), driver);
		boolean status = isElementDisplayed(verificationGroupcreated, driver);
		if (status) {
			return status;
		}

		else {
			// check on other pages
			while (!stop) {
				clickOnTheElement(paginationNext, driver);
				status = isElementDisplayed(verificationGroupcreated, driver);
				String attribute = getAttribute("class", listPageNext, driver);
				if (attribute.contains("disabled") || status == true) {
					stop = true;
				}

			}

		}
		return status;

	}

	public static ArrayList<String> verifyListOfGroupContents() {
		ArrayList<String> list = new ArrayList<String>();
//	waitUntilElementVisible(ConfigurationsPageObject.configurationsLink, driver);
//	clickOnTheElement(ConfigurationsPageObject.configurationsLink, driver);
		clickOnTheElement(listGroupValidation, driver);
		clickOnTheElement(pageNumber1, driver);
		boolean stop = false;
		while (!stop) {
			getContentsOnPage(returnContentsPresentInPage, driver, list);
			clickOnTheElement(paginationNext, driver);

			String attribute = getAttribute("class", listPageNext, driver);
			if (attribute.contains("disabled")) {
				stop = true;
			}

		}
		for (String s : list) {
			System.out.println(s);
		}

		return list;

	}

	public static void verifyEditFunctionalityForGroup() {
		clickOnTheElement(pageNumber1, driver);

		boolean stop = false;
		scrollDownUntilElementVisible(By.xpath(verificationGroupcreated), driver);
		boolean status = false;
		status = isElementDisplayed(verificationGroupcreated, driver);

		// check on other pages
		while (!stop) {
			clickOnTheElement(paginationNext, driver);
			status = isElementDisplayed(verificationGroupcreated, driver);
			String attribute = getAttribute("class", listPageNext, driver);
			if (attribute.contains("disabled") || status == true) {
				stop = true;
			}
		}
		editButton = editButton.replace("X", groupNametoBeFilled);
		clickOnTheElement(editButton, driver);
		Random rand = new Random();
		int m = rand.nextInt(1000);
		groupNametoBeFilled = groupNametoBeFilled + m;
		enterDataInTextBox(groupTextField, driver, groupNametoBeFilled);
		clickOnTheElement(submitButton, driver);

	}

	public static boolean verifyDeletefunctionalityForGroup() throws IOException, InterruptedException {
		clickOnTheElement(pageNumber1, driver);

		String groupNameDelete = DataReader.propertyFileReader("validationData.properties", "groupNameToBeDeleted");
		finder = finder.replace("X", groupNameDelete);
		boolean stop = false;
		scrollDownUntilElementVisible(By.xpath(finder), driver);
		boolean status = false;
		status = isElementDisplayed(finder, driver);
		while (!stop) {
			clickOnTheElement(paginationNext, driver);
			status = isElementDisplayed(finder, driver);
			String attribute = getAttribute("class", listPageNext, driver);
			if (attribute.contains("disabled") || status == true) {
				stop = true;
			}
		}
		deleteButton = deleteButton.replace("X", groupNameDelete);
		clickOnTheElement(deleteButton, driver);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Thread.sleep(5000);
		waitUntilElementVisible(pageNumber1, driver);
		scrollDownUntilElementVisible(pageNumber1, driver);
		clickOnTheElement(pageNumber1, driver);

		boolean stop1 = false;
		scrollDownUntilElementVisible(By.xpath(finder), driver);
		boolean status1 = false;
		status1 = isElementDisplayed(finder, driver);
		while (!stop1) {
			clickOnTheElement(paginationNext, driver);
			status = isElementDisplayed(finder, driver);
			String attribute = getAttribute("class", listPageNext, driver);
			if (attribute.contains("disabled") || status1 == true) {
				stop1 = true;
			}
		}

		return status1;

	}

	public static void createValidation() throws IOException {
		String validationName = DataReader.propertyFileReader("validationData.properties", "validationName");

		String validationType = DataReader.propertyFileReader("validationData.properties", "validationType");
		String ruleType = DataReader.propertyFileReader("validationData.properties", "RuleType");
		String property = DataReader.propertyFileReader("validationData.properties", "property");
		String number = DataReader.propertyFileReader("validationData.properties", "number");
		
		clickOnTheElement(createValidation, driver);
		enterDataInTextBox(validationTextField, driver, validationName);
		Select dropdown=new Select(driver.findElement(typeDropDown));
		dropdown.selectByVisibleText(validationType);
		clickOnTheElement(addRuleButton, driver);
		Select dropdown1=new Select(driver.findElement(fieldsdropdown));
		dropdown1.selectByVisibleText(ruleType);
		Select dropdown2=new Select(driver.findElement(operatorsdropdown));
		dropdown2.selectByValue(property);
		enterDataInTextBox(valueTextField, driver,number);
		clickOnTheElement(saveButton, driver);
		
		
		
		

	}
	
	public static ArrayList<String> listValidation()
	{
		ArrayList<String> list=new ArrayList<String>();
	clickOnTheElement(list_validation, driver);	
	waitUntilElementVisible(pageNumber1, driver);
	scrollDownUntilElementVisible(addRuleButton, driver);
	clickOnTheElement(pageNumber1, driver);
	boolean stop = false;
	while (!stop) {
		getContentsOnPage(returnContentsPresentInPage, driver, list);
		clickOnTheElement(paginationNext, driver);

		String attribute = getAttribute("class", listPageNext, driver);
		if (attribute.contains("disabled")) {
			stop = true;
		}

	}
	for (String s : list) {
		System.out.println(s);
	}

	return list;
	
	}

}
