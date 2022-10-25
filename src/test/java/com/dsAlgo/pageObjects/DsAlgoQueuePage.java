package com.dsAlgo.pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DsAlgoQueuePage {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public Actions action;
	
	@FindBy (xpath = "//a[@href='implementation-lists']") WebElement queueInPython;
	@FindBy (xpath = "//a[@href='implementation-collections']") WebElement collectionsLink;
	@FindBy (xpath = "//a[@href='Implementation-array']") WebElement arrayLink;
	@FindBy (xpath = "//a[@href='QueueOp']") WebElement queueOperations;
	
	@FindBy (xpath = "//a[text()='Try here>>>']") WebElement tryHereBtn;
	//@FindBy (className = "CodeMirror-scroll") WebElement tryEditorInput;
	
	@FindBy (xpath = "//a[text()='Practice Questions']") WebElement pracQues;
	@FindBy (xpath = "//textarea[@tabindex='0']") WebElement codeArea;
	@FindBy (xpath = "//span[@role='presentation']") WebElement codeAreaText;
	@FindBy (xpath = "//button[text()='Run']") WebElement runBtn;
	@FindBy (xpath = "//pre[@id='output']") WebElement output;
	

	public DsAlgoQueuePage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
		PageFactory.initElements(this.driver, this);
		action = new Actions(this.driver);
	}
	
	public void clickImpQueueInPython(){
		System.out.println("Inside clickImpQueueInPython");
		//wait.until(ExpectedConditions.elementToBeClickable(queueInPython));
			//	visibilityOf(queueInPython));
		//Java Script Executor scroll
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
		action.moveToElement(queueInPython);
		queueInPython.click();
	}
	
	public void clickCollectionsLink(){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
		action.moveToElement(collectionsLink);
		collectionsLink.click();
	}
	
	public void clickArrayLink(){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
		action.moveToElement(arrayLink);
		arrayLink.click();
	}
	public void clickQueueOperations(){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
		action.moveToElement(queueOperations);
		queueOperations.click();
	}
	
	
	public void clickTryHereBtn(){
		wait.until(ExpectedConditions.elementToBeClickable(tryHereBtn));
		tryHereBtn.click();
	}
	
	public boolean verifyTryEditorPage()
	{
		boolean status;
		status = driver.getTitle().equals("Assessment");
		driver.navigate().back();
		driver.navigate().back();
		return status;
	}
	
	public void clickRunBtn()
	{
		codeArea.sendKeys("print('Hello')");
		runBtn.click();
		
	}
	public boolean verifyOutput()
	{
		System.out.println("verifyOutput :"+output.getText());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("verifyOutput After:"+output.getText());
		String out = output.getText();
		if(out.equals("Hello"))
		{
			return true;
		}
		else
			return false;
	}
	
	public void clickPracticeQuestions()
	{
		wait.until(ExpectedConditions.elementToBeClickable(pracQues));
		pracQues.click();
	}
	
	public boolean isInPracticeQuesPage()
	{
		System.out.println("PracQ Title :"+driver.getTitle());
		boolean status;
		if(driver.getTitle().equals("Practice Questions"))
		{
			driver.navigate().back();
			driver.navigate().back();
			status = true;
		}
		else
			status =false;
		return status;
	}
	
	
	public boolean isImpQueueInPythonPage(){
		boolean status;
		System.out.println("isImpQueueInPythonPage :"+driver.getTitle());
		if(driver.getTitle().equals("Implementation of Queue in Python"))
		{
			driver.navigate().back();
			status = true;
		}
		else
			status = false;
		return status;
	}
	
	
	public boolean isQueuePageOpen(){
		return driver.getTitle().equals("Queue");
	}
	

	
}


