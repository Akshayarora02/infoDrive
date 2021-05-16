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

public class FieldMappingPageObject extends BaseTest {

	public static By fieldMapping = By.xpath(" //a[text()='Field Mapping']");
	public static By list_validation = By.xpath(" //a[text()='List' and contains(@href,'validation')]");
	public static By createValidation = By.xpath("//a[contains(text(),'Create Validation')]");
	public static By addFieldMapping = By.xpath("//button[text()='Add Field Mapping']");
	public static By createGroups = By
			.xpath(" //a[contains(text(),'Create Group')]");
	public static By listGroupFieldMapping = By
			.xpath(" //a[contains(text(),'List Group')]");
	public static String editButton = " //td[text()='X']//..//td[2]//button[1]";
	public static String deleteButton = "//td[text()='X']//..//td[2]//div//following-sibling::button//i";

	public static By fieldTextField = By.xpath("//input[@name='fname']");
	public static By sourceFieldNameTextField = By.xpath("//input[@name='sourceFieldName']");
	
	public static By targetFieldDropDown = By.xpath(" //select[@name='targetField']");
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
	public static String fieldMappingChecker = "//span[text()='X']";
	public static String finder = "//td[text()='X']";
	public static String finder1 = "//td[text()='X']";
	public static String finder2 = "//td[text()='X']";
	public static By returnContentsPresentInPage = By
			.xpath("//table[@class='overflow-hidden table']//tbody//tr//td[1]");
	public static By pageNumber1 = By.xpath("//a[text()='1']");
	public static By returnContentsPresentInPage1 = By
			.xpath("//table[@class='overflow-hidden table']//tbody//tr//td[2]");

public static void navigateToFieldMapping() throws InterruptedException
{
	Thread.sleep(5000);
	waitUntilElementVisible(ConfigurationsPageObject.configurationsLink, driver);
	clickOnTheElement(ConfigurationsPageObject.configurationsLink, driver);
	clickOnTheElement(fieldMapping, driver);
}
	public static void creatingFieldMappingAndVerifying() throws InterruptedException, IOException {
Thread.sleep(3000);
		String fieldMappingName = DataReader.propertyFileReader("FieldMapping.properties", "fieldMappingName");
		String sourceFieldName = DataReader.propertyFileReader("FieldMapping.properties", "sourceFieldName");
		String targetFieldName = DataReader.propertyFileReader("FieldMapping.properties", "targetFieldName");
		clickOnTheElement(addFieldMapping, driver);
		clearTextBox(fieldTextField, driver);
		enterDataInTextBox(fieldTextField, driver, fieldMappingName);
		clearTextBox(sourceFieldNameTextField, driver);
		enterDataInTextBox(sourceFieldNameTextField, driver, sourceFieldName);
		Select dropdown = new Select(driver.findElement(targetFieldDropDown));
		dropdown.selectByVisibleText(targetFieldName);

		clickOnTheElement(saveButton, driver);
		Thread.sleep(9000);
//checking whether validation has created or not 
		fieldMappingChecker = fieldMappingChecker.replace("X", fieldMappingName);
		boolean status = isElementDisplayed(fieldMappingChecker, driver);

		Assert.assertEquals(status, true);

		
		clickOnTheElement(submitButton, driver);
		Thread.sleep(5000);
	}


	
}
