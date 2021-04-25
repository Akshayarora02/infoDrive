package com.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.infodrive.pageobjects.LoginPageObject;

public class UtilityMethods extends BaseTest  {

	public static void launchtheURL() throws IOException
	{
		String url=DataReader.generateUrl();
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static void login() throws IOException
	{
		LoginPageObject.LoginToApplication();
	}

public static void takeScreenshot() throws IOException
{
	TakesScreenshot scr =(TakesScreenshot) driver;
	File src= scr.getScreenshotAs(OutputType.FILE);
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Random rand = new Random();
    int rand_int1 = rand.nextInt(1000);
	String fileName = dateFormat.format(cal.getTime());
	
   
String path = System.getProperty("user.dir");

System.out.println("Working Directory = " + path);
File dest=new File(path+"//output//"+fileName+rand_int1+".png");
FileUtils.copyFile(src, dest);
}

public static void clickOnTheElement(By element,WebDriver driver)
{
	driver.findElement(element).click();
}
public static void enterDataInTextBox(By element,WebDriver driver,String text)
{
	driver.findElement(element).sendKeys(text);
}
}




