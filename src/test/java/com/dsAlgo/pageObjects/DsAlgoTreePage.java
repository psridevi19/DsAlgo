package com.dsAlgo.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DsAlgoTreePage {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@FindBy (xpath = "//a[@href='overview-of-trees']") WebElement overviewOfTrees;
	@FindBy (xpath = "//a[text()='Terminologies']") WebElement terminologies;
	@FindBy (xpath = "//a[text()='Types of Trees']") WebElement typesOfTrees;
	@FindBy (xpath = "//a[text()='Tree Traversals']") WebElement treeTraversals;
	@FindBy (xpath = "//a[text()='Traversals-Illustration']") WebElement traversalsIllustration;
	@FindBy (xpath = "//a[text()='Binary Trees']") WebElement binaryTrees;
	@FindBy (xpath = "//a[text()='Types of Binary Trees']") WebElement typesOfBinaryTrees;
	@FindBy (xpath = "//a[text()='Implementation in Python']") WebElement impInPython;
	@FindBy (xpath = "//a[text()='Binary Tree Traversals']") WebElement binaryTreeTraversals;
	@FindBy (xpath = "//a[text()='Implementation of Binary Trees']") WebElement impInBinaryTrees;
	@FindBy (xpath = "//a[text()='Applications of Binary trees']") WebElement appOfBinaryTrees;
	@FindBy (xpath = "//a[text()='Binary Search Trees']") WebElement Bst;
	@FindBy (xpath = "//a[text()='Implementation Of BST']") WebElement impOfBST;
	
	
	
	@FindBy (xpath = "//a[text()='Try here>>>']") WebElement tryHereBtn;
	
	public DsAlgoTreePage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(5));
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickOverviewOfTrees() {
		overviewOfTrees.click();
	}
	
	public void clickTerminologies() {
		terminologies.click();
	}
	
	public void clickTypesOfTrees() {
		typesOfTrees.click();
	}
	
	public void clickTreeTraversals() {
		treeTraversals.click();
	}
	
	public void clickTraversalsIllustration() {
		traversalsIllustration.click();
	}
	
	public void clickBinaryTrees() {
		binaryTrees.click();
	}
	
	public void clickTypesOfBinaryTrees() {
		typesOfBinaryTrees.click();
	}
	
	public void clickImpInPython() {
		impInPython.click();
	}
	
	public void clickBinaryTreeTraversals() {
		binaryTreeTraversals.click();
	}
	
	public void clickImpInBinaryTrees() {
		impInBinaryTrees.click();
	}
	
	public void clickAppOfBinaryTrees() {
		appOfBinaryTrees.click();
	}
	
	public void clickBST() {
		Bst.click();
	}
	
	public void clickImpOfBST() {
		impOfBST.click();
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
	public boolean isTreePageOpen(){
		return driver.getTitle().equals("Tree");
	}
	
	
	
}
