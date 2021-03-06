package com.infodrive.pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.utilities.BaseTest;
import com.utilities.DataReader;
import static com.utilities.UtilityMethods.*;

public class ValidationPageObject extends BaseTest {

	public static By validationLink = By.xpath(" //a[text()='Validation']");
	public static By list_validation = By.xpath(" //a[text()='List' and contains(@href,'validation')]");
	public static By createValidation = By.xpath("//a[contains(text(),'Create Validation')]");
	public static By addValidation = By.xpath("//button[text()='Add Validation']");
	public static By createGroupValidation = By
			.xpath(" //a[contains(text(),'Create Group') and contains(@href,'validation')]");
	public static By listGroupValidation = By
			.xpath(" //a[contains(text(),'List Group') and contains(@href,'validation')]");
	public static String editButton = " //td[text()='X']//..//td[2]//button[1]";
	public static String deleteButton = "//td[text()='X']//..//td[2]//div//following-sibling::button//i";

	public static By validationTextField = By.xpath("//input[@name='validation']");
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
	public static By searchBox = By.xpath("//input[@placeholder='Enter Name...']");
	public static String groupNametoBeFilled = "";
	final String[] validationLinks = { "List", "Create Validation", "Create Group", "List Group" };
	public static String verificationGroupcreated = "//td[text()='X']";
	public static String validationChecker = "//td[text()='X']";
	public static String finder = "//td[text()='X']";
	public static String finder1 = "//td[text()='X']";
	public static String finder2 = "//td[text()='X']";
	public static By returnContentsPresentInPage = By
			.xpath("//table[@class='overflow-hidden table']//tbody//tr//td[1]");
	public static By pageNumber1 = By.xpath("//a[text()='1']");
	public static By returnContentsPresentInPage1 = By
			.xpath("//table[@class='overflow-hidden table']//tbody//tr//td[2]");
	public static void navigateToValidations() throws InterruptedException
	{
		Thread.sleep(9000);
		waitUntilElementVisible(ConfigurationsPageObject.configurationsLink, driver);
		clickOnTheElement(ConfigurationsPageObject.configurationsLink, driver);
		clickOnTheElement(validationLink, driver);
	}


	public static void creatingValidationAndVerifying() throws InterruptedException, IOException {

		Thread.sleep(5000);
		String validationName = DataReader.propertyFileReader("validationData.properties", "validationName");

		String validationType = DataReader.propertyFileReader("validationData.properties", "validationType");
		String ruleType = DataReader.propertyFileReader("validationData.properties", "RuleType");
		String property = DataReader.propertyFileReader("validationData.properties", "property");
		String number = DataReader.propertyFileReader("validationData.properties", "number");

		clickOnTheElement(addValidation, driver);
		clearTextBox(validationTextField, driver);
		enterDataInTextBox(validationTextField, driver, validationName);
		Select dropdown = new Select(driver.findElement(typeDropDown));
		dropdown.selectByVisibleText(validationType);

		clickOnTheElement(saveButton, driver);
		Thread.sleep(5000);
//checking whether validation has created or not 
		validationChecker = validationChecker.replace("X", validationName);
		boolean status = isElementDisplayed(validationChecker, driver);

		Assert.assertEquals(status, true);
		Thread.sleep(5000);
	}

	public static ArrayList<String> verifyListOfGroupContents() {
		ArrayList<String> list = new ArrayList<String>();
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

}
