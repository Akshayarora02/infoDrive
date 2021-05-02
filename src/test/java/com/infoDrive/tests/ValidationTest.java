package com.infoDrive.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;

import javax.management.DescriptorKey;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.infodrive.pageobjects.LoginPageObject;
import com.infodrive.pageobjects.ValidationPageObject;
import com.utilities.BaseTest;
import com.utilities.UtilityMethods;

public class ValidationTest extends BaseTest {

	@BeforeTest

	public void launch() throws IOException {
		UtilityMethods.launchtheURL();
		UtilityMethods.login();
	}

	@Test(description = "Create Group Test", priority = 0, groups = "Validation Group")

	public void validationTest() throws Exception {
		boolean status = ValidationPageObject.createGroup();
		if (status) {
			System.out.println("The group has been successfully created");
			AssertJUnit.assertTrue(true);
		} else {
			System.out.println("Failed !!!!");
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Verify all the content should be visible on validation--list group window", priority = 1, groups = "Validation Group")
	public void validationtest2() {
		ArrayList<String> list = ValidationPageObject.verifyListOfGroupContents();
		if (list.size() != 0) {
			AssertJUnit.assertTrue(true);
		} else {
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = " delete functionality of group", priority = 2, groups = "Validation Group")
	public void validationtest3() throws IOException, InterruptedException {
		boolean status = ValidationPageObject.verifyDeletefunctionalityForGroup();
		if (!status) {
			System.out.println("The group has been successfully deleted");
			AssertJUnit.assertTrue(true);
		} else {
			System.out.println("Failed !!!!");
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = " Edit functionality of group", priority = 3, groups = "Validation Group", enabled = false)
	public void validationtest5() throws IOException, InterruptedException {
		ValidationPageObject.verifyEditFunctionalityForGroup();

	}

	@Test(description = " Create Validation", priority = 4, groups = "Validation", enabled = false)
	public void validationtest6() throws IOException, InterruptedException {
		ValidationPageObject.createValidation();

	}

	@Test(description = " List Validation", priority = 5, groups = "Validation")
	public void validationtest7() throws IOException, InterruptedException {
		ArrayList<String> list = ValidationPageObject.listValidation();
		if (list.size() != 0) {
			AssertJUnit.assertTrue(true);
		} else {
			AssertJUnit.assertTrue(false);
		}

	}

	@Test(description = " Delete Validation", priority = 5, groups = "Validation")
	public void validationtest8() throws IOException, InterruptedException {
		boolean status = ValidationPageObject.deleteFunctionalityValidation();
		if (!status) {
			System.out.println("The validation has been successfully deleted");
			AssertJUnit.assertTrue(true);
		} else {
			System.out.println("NOt found,Please check data !!!!");
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = " Edit Validation", priority = 6, groups = "Validation" ,enabled=false)
	public void validationtest9() throws IOException, InterruptedException {
		ValidationPageObject.editFunctionalityValidation();
	}

	@AfterSuite
	public void doAfterTest() {
		LoginPageObject.LogoutFromApplication();
	}

}
