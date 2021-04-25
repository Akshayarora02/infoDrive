package com.infodrive.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.utilities.UtilityMethods.*;

import com.utilities.BaseTest;
import com.utilities.DataReader;
import com.utilities.UtilityMethods;

public class NewJobSubmission extends BaseTest {

	public static By newJobSumbission = By.xpath("//span[text()='New Job Submission']");

	public static By searchBox = By.xpath("//input[@placeholder='S3 Filepath']");

	public static By searchTemplateBox = By.xpath("//input[@placeholder='Search Template']");
	public static By searchButton = By.xpath("//button[text()='Search']");
	public static By jobTemplates = By.xpath("(//input[@name='jobTemplates'])[1]");
	public static By previewButton = By.xpath("//button[text()='Preview Records ->']");

	public static void doSearch() throws IOException, InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		clickOnTheElement(newJobSumbission, driver);
		String textToSearch = DataReader.propertyFileReader();
		enterDataInTextBox(searchBox, driver, textToSearch);
		clickOnTheElement(searchButton, driver);
		takeScreenshot();
		Thread.sleep(25000);
		clickOnTheElement(jobTemplates, driver);
		clickOnTheElement(previewButton, driver);
		Thread.sleep(5000);
		takeScreenshot();

	}

}
