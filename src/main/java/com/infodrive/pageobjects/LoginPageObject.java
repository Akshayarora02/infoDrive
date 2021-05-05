package com.infodrive.pageobjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.utilities.UtilityMethods.*;

import com.utilities.BaseTest;
import com.utilities.DataReader;

public class LoginPageObject extends BaseTest {

	public LoginPageObject(WebDriver dr) {
		dr = BaseTest.driver;
		PageFactory.initElements(dr, LoginPageObject.class);
	}

	public static By usernameTextField = By.xpath("//input[@type='email']");

	public static By passwordTextField = By.xpath("//input[@type='password']");

	public static By loginButton = By.xpath("//button[text()='Sign in']");

	public static By logoutButton = By
			.xpath("(//p//i)[5]//..//..//..//following-sibling::ul//li//span[text()='Log Out']");
	public static By registerButton = By.xpath("//button[text()='Register'] | //a[text()='Register']");
	public static By codeTextField = By.xpath("//input[@placeholder='code']");
	public static By confirmSignup = By.xpath("//button[text()='Confirm Sign Up']");

	public static void LoginToApplication() throws IOException {
		HashMap<String, String> map = DataReader.credentialsReader();
		String username = "";
		String password = "";
		for (Map.Entry<String, String> entry : map.entrySet()) {
			username = entry.getKey();
			password = entry.getValue();

		}
		String url = driver.getCurrentUrl();
		enterDataInTextBox(usernameTextField, driver, username);
		enterDataInTextBox(passwordTextField, driver, password);
		takeScreenshot();
		clickOnTheElement(loginButton, driver);

	}

	public static void LogoutFromApplication() {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath("(//p//i)[5]"))).perform();

			clickOnTheElement(logoutButton, driver);
			driver.close();
		} catch (Exception e) {
			driver.close();
		}
	}

	public static boolean doRegistration(String username, String password) {

		try {
			Thread.sleep(5000);
			waitUntilElementVisible(registerButton, driver);
			clickOnTheElement(registerButton, driver);
			enterDataInTextBox(usernameTextField, driver, username);
			enterDataInTextBox(passwordTextField, driver, password);
			clickOnTheElement(registerButton, driver);
			String alertBoxMessage = "";
			try {
				Thread.sleep(3000);
				Alert alert = driver.switchTo().alert();
				alertBoxMessage = alert.getText();
				System.out.println(alertBoxMessage);
				alert.accept();
				return false;
			} catch (Exception e) {
				System.out.println("*******************No alert box is present*********************************");

			}
			driver.switchTo().defaultContent();
			System.out.println("Please enter the code");
			long then = System.currentTimeMillis();
			Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();

			long now = System.currentTimeMillis();
			System.out.printf("Waited %.3fs for user input%n", (now - then) / 1000d);
			System.out.printf("User input was: %s%n", s);
			enterDataInTextBox(codeTextField, driver, s);
			clickOnTheElement(confirmSignup, driver);
			boolean flag = true;
			int count = 0;
			Thread.sleep(3000);
			if (driver.switchTo().alert().getText().equalsIgnoreCase("Something went Wrong")) {
				while (flag) {
					{
						count++;
						String text = driver.switchTo().alert().getText();
						if (!text.equalsIgnoreCase("Something went Wrong") || count == 5) {
							flag = false;
						}
						driver.switchTo().alert().accept();
						driver.switchTo().defaultContent();
						System.out.println("The code you entered is wrong,Enter again");
						s = sc.nextLine();
						clearTextBox(codeTextField, driver);
						enterDataInTextBox(codeTextField, driver, s);
						clickOnTheElement(confirmSignup, driver);
						Thread.sleep(3000);
					}
				}
				if (count == 5) {
					System.out.println("You are out of tries now ,Please Enter Genuine email");
					return false;
				}

			} else {
				return true;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
