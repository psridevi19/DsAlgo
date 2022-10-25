package com.dsAlgo.pageObjects;

import java.lang.System.Logger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dsAlgo.utilities.LoggerClass;

public class DsAlgoRegisterPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(name = "username") WebElement userName;
	@FindBy(name = "password1") WebElement password;
	@FindBy(name = "password2") WebElement confirmPassword;
	@FindBy(xpath = "//input[@type='submit']") WebElement registerBtn;
	@FindBy(xpath = "//div[@role='alert']") WebElement alert;
	
	
	public DsAlgoRegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
	}
	
	public void registration(String username, String pwd, String confirmPwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		registerBtn.click();
	}
	
	public boolean isInRegisterPage()
	{
		return driver.getTitle().equals("Registration");
	}
	public boolean isInHomePage()
	{
		return driver.getTitle().equals("NumpyNinja");
	}
	
	public boolean alertMsg(){
		LoggerClass.info(alert.getText());
		return alert.getText().contains("password_mismatch:The two password fields didn’t match");
	}
	
	public boolean alertMsgAlreadyRegistered() {
		LoggerClass.info(alert.getText());
		return alert.getText().contains("Username is already registered");
	}
	
	public boolean validationMsgEmptyFields()
	{
		LoggerClass.info("Validation message : "+driver.findElement(By.name("username")).getAttribute("validationMessage"));
		String message = driver.findElement(By.name("username")).getAttribute("validationMessage");  
		return message.equals("Please fill out this field.");
	}
}
