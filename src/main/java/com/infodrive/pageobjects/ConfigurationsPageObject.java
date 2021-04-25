package com.infodrive.pageobjects;
import static com.utilities.UtilityMethods.*;

import org.openqa.selenium.By;

import com.utilities.BaseTest;

public class ConfigurationsPageObject extends BaseTest {
	
	
	
public static By configurationsLink =By.xpath("//span[text()='Configurations']");
public static By universalFieldsLink=By.xpath("//a[text()='Universal Fields']");
public static By validationLink=By.xpath("//a[text()='Validation']");
public static By fieldMappinLink=By.xpath("//a[text()='Field Mapping']");
public static By enrichmentLink=By.xpath("//a[text()='Enrichment']");
public static By processorLink=By.xpath("//a[text()='Processor']");
public static By jobExecutionTemplateLink =By.xpath("//a[text()='JobExecutionTemplate']");
	
	
}
