package com.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.infodrive.pageobjects.LoginPageObject;

import okio.Timeout;

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
public static void clickOnTheElement(String element,WebDriver driver)
{
	driver.findElement(By.xpath(element)).click();
}
public static void scrollDownUntilElementVisible(By element,WebDriver driver)
{
	try
	{
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
	}
	catch(Exception e)
	{
		e.getMessage();
		
	}
	}

public static void waitUntilElementVisible(By element,WebDriver driver)
{
	try
	{
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	}
public static void windowhandle(String windowname)
{
	Set<String> windows =driver.getWindowHandles();
Iterator<String>  it =windows.iterator();

while(it.hasNext())
{
	String name =it.next();
if(name.equalsIgnoreCase(windowname))
{
	driver.switchTo().window(name);
}

}

}
public static boolean isElementDisplayed(By weblement,WebDriver driver)
{
	if(driver.findElement(weblement).isDisplayed())
	{
		return true;
	}
	else
	{
		return false;
	}
}
	public static boolean isElementDisplayed(String weblement,WebDriver driver)
	{
	int size=	driver.findElements(By.xpath(weblement)).size();
	if(size!=0)	
	{
			return true;
		}
		else
		{
			return false;
		}
}
	
	
	public static String getAttribute(String attribute,By webelement ,WebDriver driver)

{
		
		String att=driver.findElement(webelement).getAttribute(attribute);
		
		
		return att;
		}
	
	public static ArrayList<String> getContentsOnPage(By xpath ,WebDriver driver,ArrayList<String> list)
	{
		
	List<WebElement> webelements=driver.findElements(xpath);
		for(WebElement element:webelements)
		{
			String text=element.getText();
			list.add(text);
			
		}
		return list;
		
	}
	public static void clearTextBox(By xpath,WebDriver driver)
	{
		try
		{
		driver.findElement(xpath).clear();
	}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	}




