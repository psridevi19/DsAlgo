package com.dsAlgo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DsAlgoLoginPage {
	WebDriver driver;

	@FindBy (name ="username")
	WebElement userName;
	
	@FindBy (name ="password")
	WebElement passWord;
	
	@FindBy (xpath ="//input[@value='Login']")
	WebElement login;
	
	@FindBy (xpath ="//a[text()='Sign out']")
	WebElement signOut;

	
	public DsAlgoLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void login(String username,String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		login.click();
	}
	
	public String getHomePageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void clickSignOut()
	{
		signOut.click();
	}
	
	public boolean isLoginPageOpen()
	{
		return driver.getTitle().equals("Login");
	}
}
