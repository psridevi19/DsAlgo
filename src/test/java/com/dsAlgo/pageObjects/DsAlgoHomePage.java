package com.dsAlgo.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dsAlgo.utilities.LoggerClass;

public class DsAlgoHomePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy (xpath ="//a[text()='Sign in']") WebElement signIn;
	@FindBy (xpath ="//a[text()='Sign out']") WebElement signOut;
	//@FindBy (linkText ="/register") WebElement register;
	@FindBy (xpath ="//a[contains(text(),' Register ')]") WebElement register;
	@FindBy (xpath ="//a[@data-toggle='dropdown']") WebElement dropdown;
	@FindBy (xpath ="//a[@class='dropdown-item']") List<WebElement> dropdownList;
	@FindBy (className ="navbar-brand") WebElement navbar;
	@FindBy (xpath ="//a[@href='array']") WebElement arrayNav;
	@FindBy (xpath ="//a[@href='queue']") WebElement queueNav;
	@FindBy (xpath = "//a[@href='tree']") WebElement TreeNav;
	@FindBy (xpath ="//div[@role='alert']") WebElement alertMsgNotloggin;
	@FindBy (xpath ="//h4[text()='Array']") WebElement arrayPageHeading;
	@FindBy (xpath ="//h4[text()='Queue']") WebElement queuePageHeading;
	@FindBy (xpath ="//h4[text()='Tree']") WebElement treePageHeading;
	@FindBy (xpath ="//a[text()='Arrays']") WebElement arrayFromDropdownMenu;
	
	@FindBy(xpath = "//div[@role='alert']") WebElement newAccount;
	
	
	
	public DsAlgoHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
	}
	
	public void clickSignIn(){
		wait.until(ExpectedConditions.visibilityOf(signIn));
		signIn.click();
	}
	
	public void clickSignOut(){
		wait.until(ExpectedConditions.visibilityOf(signOut));
		signOut.click();
	}
	public void clickRegister(){
		wait.until(ExpectedConditions.visibilityOf(register));
		register.click();
	}
	
	public void clickDropDown(){
		dropdown.click();
	}
	
	public boolean verifyDropdownMenu(List<String> dropDownMenuList){
		List<String> menuList = new ArrayList<String>();
		
		for(int i =0; i<dropdownList.size(); i++)
		{
			System.out.println("list sentt :"+dropDownMenuList.get(i));
			menuList.add(dropdownList.get(i).getText());
			System.out.println("lists :"+menuList.get(i));
		}
		return dropDownMenuList.equals(menuList);
	}
	/*
	public boolean verifyDropdownMenu(String[] dropDownMenuList){
		String[] menuList = new String[dropdownList.size()];
		
		for(int i =0; i<dropdownList.size(); i++)
		{
			System.out.println("list sent :"+dropDownMenuList[i]);
			menuList[i]=dropdownList.get(i).getText();
			System.out.println("lists :"+menuList[i]);
		}
		return Arrays.equals(dropDownMenuList, menuList);
	}
	*/
	public void navigateToArrayPage(){
		arrayNav.click();
	}
	
	public void navigateToQueuePage(){
		queueNav.click();
	}
	
	public void navigateToTreePage() {
		TreeNav.click();
	}
	
	public String verifyNotLogginAlertMsg(){
		wait.until(ExpectedConditions.visibilityOf(alertMsgNotloggin));
		if(alertMsgNotloggin.isDisplayed())
		{
			return alertMsgNotloggin.getText().trim();
		}
		else
			return null;
	}
	
	
	public void NavigateArrayPageFromDropdownMenu(){
		wait.until(ExpectedConditions.visibilityOf(arrayFromDropdownMenu));
		arrayFromDropdownMenu.click();
	}
	
	
	public String getLoginPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean isHomePageOpen(){
		return driver.getTitle().equals("NumpyNinja");
	}
	
	public String getRegisterPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public void loginToPortalPage(){
		navbar.click();
	}
	
	public void registerToPortalPage(){
		navbar.click();
	}
	public boolean verifyArrayPageHeader(){
		System.out.println("Header "+arrayPageHeading.getText());
		if(arrayPageHeading.getText().equals("Array"))
			return true;
		else
			return false;
	}
	
	public boolean verifyQueuePageHeader(){
		System.out.println("Header "+queuePageHeading.getText());
		if(queuePageHeading.getText().equals("Queue"))
			return true;
		else
			return false;
	}
	
	public boolean verifyTreePageHeader(){
		System.out.println("Header "+treePageHeading.getText());
		if(treePageHeading.getText().equals("Tree"))
			return true;
		else
			return false;
	}
	
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public boolean isNewAccountCreated(){
		LoggerClass.info("isNewAccountCreated : Checking new account creation");
		return newAccount.getText().contains("New Account Created");
	}
}