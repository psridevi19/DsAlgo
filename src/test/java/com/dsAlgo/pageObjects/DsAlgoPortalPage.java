package com.dsAlgo.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DsAlgoPortalPage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy (xpath ="//button[text()='Get Started']") 
	WebElement getStarted;
	
	
	public DsAlgoPortalPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(1));
		PageFactory.initElements(this.driver,this);
		
	}
	
	public void clickToHome()
	{
		getStarted.click();
	}
	
	public String getHomePageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
}
