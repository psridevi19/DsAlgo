package com.dsAlgo.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsAlgo.base.BaseClass;
import com.dsAlgo.pageObjects.DsAlgoHomePage;
import com.dsAlgo.pageObjects.DsAlgoLoginPage;
import com.dsAlgo.pageObjects.DsAlgoPortalPage;
import com.dsAlgo.pageObjects.DsAlgoQueuePage;
import com.dsAlgo.pageObjects.DsAlgoTreePage;

public class TC_DsAlgoTreeTest extends BaseClass{
	private DsAlgoHomePage homePage;
	private DsAlgoPortalPage portalPage;
	private DsAlgoQueuePage queuePage;
	private DsAlgoTreePage treePage;
	
	public static Logger logger;
	@BeforeClass
	public void loggerObj()
	{
		logger=(Logger) LogManager.getLogger();
	}
	
	@BeforeMethod
	public void clients(){
		homePage = new DsAlgoHomePage(driver);
		portalPage = new DsAlgoPortalPage(driver);
		queuePage = new DsAlgoQueuePage(driver);
		treePage = new DsAlgoTreePage(driver);
	}
	
	@Test
	public void VerifyOverviewOfTrees()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickOverviewOfTrees();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("Try editor from Overview of trees");
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
	@Test
	public void VerifyTerminologies()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickTerminologies();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("Try editor from Terminologies");
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
	
	@Test
	public void VerifyTypesOfTrees()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickTypesOfTrees();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor from Types of trees");
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
	@Test
	public void VerifyTreeTraversals()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickTreeTraversals();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from tree traversals");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from tree traversals");
		}
	}
	
	
	@Test
	public void verifyTraversalsIllustration()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickTraversalsIllustration();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Traversals Illustration");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Traversals Illustration");
		}
	}
	
	@Test
	public void verifyBinaryTrees()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickBinaryTrees();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Binary Trees");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Binary Trees");
		}
	}
	
	@Test
	public void verifyTypesOfBinaryTrees()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickTypesOfBinaryTrees();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Types Of Binary Trees");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Types Of Binary Trees");
		}
	}
	
	@Test
	public void verifyImpInPython()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickImpInPython();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Implementation in Python");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Implementation in Python");
		}
	}
	
	@Test
	public void verifyBinaryTreeTraversals()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickBinaryTreeTraversals();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Binary Tree Traversals");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Binary Tree Traversals");
		}
	}
	
	@Test
	public void verifyImpInBinaryTrees()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickImpInBinaryTrees();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Implementation in Binary Trees");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Implementation in Binary Trees");
		}
	}
	
	@Test
	public void verifyAppOfBinaryTrees()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickAppOfBinaryTrees();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Application of Binary Trees");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Application of Binary Trees");
		}
	}

	@Test
	public void verifyImpOfBST()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickImpOfBST();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Implementation of BST");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Implementation of BST");
		}
	}

	@Test
	public void verifyBST()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!treePage.isTreePageOpen())
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToTreePage();
		}
		treePage.clickBST();
		treePage.clickTryHereBtn();
		if(treePage.verifyTryEditorPage()){
			
			logger.info("In Try editor, from Binary Search Tree");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Not in Try editor, from Binary Search Tree");
		}
	}
}
