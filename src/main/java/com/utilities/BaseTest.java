package com.utilities;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
	

public static	WebDriver driver;
static
	{
	
	
WebDriverManager.chromedriver().setup();
 driver =new ChromeDriver();
driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}

	
	
}
