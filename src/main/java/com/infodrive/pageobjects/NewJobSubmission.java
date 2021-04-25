package com.infodrive.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.BaseTest;
import com.utilities.DataReader;

public class NewJobSubmission  extends BaseTest{



	public static By newJobSumbission =By.xpath("//span[text()='New Job Submission']");
	
	public static By searchBox=By.xpath("//input[@placeholder='S3 Filepath']");
	
	public static By searchTemplateBox=By.xpath("//input[@placeholder='Search Template']");
	public static By searchButton =By.xpath("//button[text()='Search']");
	
	public static void doSearch() throws IOException
	{
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver,80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newJobSumbission));
		driver.findElement(newJobSumbission).click();
		String textToSearch =DataReader.propertyFileReader();
		driver.findElement(searchBox).sendKeys(textToSearch);
		driver.findElement(searchButton).click();
	}
	
	
}
