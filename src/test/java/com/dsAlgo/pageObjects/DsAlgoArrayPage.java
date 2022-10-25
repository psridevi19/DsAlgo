package com.dsAlgo.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DsAlgoArrayPage {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public Actions action;
	
	
	@FindBy (xpath = "//a[text()='Arrays in Python']") WebElement arraysInPython;
	@FindBy (xpath = "//a[text()='Practice Questions']") WebElement pracQues;
	@FindBy (xpath = "//a[text()='Search the array']") WebElement searchArray;
	//@FindBy (xpath = "//span[@role='presentation']") WebElement tryeditarray;
	//@FindBy (className = "cm-keyword") WebElement tryeditarray;
	//@FindBy (id = "editor") WebElement tryeditarray;
	@FindBy (xpath = "//strong[text()='QUESTION']") WebElement heading;
	//@FindBy (xpath = "//pre[@class=' CodeMirror-line ']") WebElement tryeditarray;
	@FindBy (xpath = "//textarea[@tabindex='0']") WebElement codeArea;
	@FindBy (xpath = "//span[@role='presentation']") WebElement codeAreaText;

	
	
	
	public DsAlgoArrayPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
		PageFactory.initElements(this.driver, this);
		action = new Actions(this.driver);
	}
	
	public boolean arraytest() {
		arraysInPython.click();
		pracQues.click();
		searchArray.click();
		
	
		codeArea.sendKeys(Keys.CONTROL+"a");
		codeArea.sendKeys(Keys.DELETE);
		codeArea.sendKeys("print('Hello')");
	
		System.out.println("Code Area :"+codeAreaText.getText());
		if (codeAreaText.getText().equals("print('Hello')"))
			return true;
		else
			return false;
		//codeArea.sendKeys("hello");
	}
	
	
	
}
