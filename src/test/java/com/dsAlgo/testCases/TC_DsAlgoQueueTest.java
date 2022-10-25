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

public class TC_DsAlgoQueueTest extends BaseClass{

	private DsAlgoHomePage homePage;
	private DsAlgoPortalPage portalPage;
	private DsAlgoQueuePage queuePage;
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
	}
	
	@Test
	public void verifyLinkImpQueueInPython(){
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		
		if(!queuePage.isQueuePageOpen()) {
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToQueuePage();
		}
		
		queuePage.clickImpQueueInPython();
		if(queuePage.isImpQueueInPythonPage())
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
	}
		
		/*
		queuePage.clickTryHereBtn();
		if(queuePage.verifyTryEditorPage()) {
			
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
			*/
	
	@Test
	public void verifyRunBtnFromQueue()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		
		if(!queuePage.isQueuePageOpen()) {
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToQueuePage();
		}
		queuePage.clickImpQueueInPython();
		queuePage.clickTryHereBtn();
		queuePage.clickRunBtn();
		
		if(queuePage.verifyOutput()) {
			
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
	}
	
	
	@Test
	public void verifyCollectionsLink(){
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		
		if(!queuePage.isQueuePageOpen()) {
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToQueuePage();
		}
		
		queuePage.clickCollectionsLink();
		queuePage.clickTryHereBtn();
		if(queuePage.verifyTryEditorPage()) {
			
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
	@Test
	public void verifyArrayLink(){
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		
		if(!queuePage.isQueuePageOpen()) {
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToQueuePage();
		}
		
		queuePage.clickArrayLink();
		queuePage.clickTryHereBtn();
		if(queuePage.verifyTryEditorPage()) {
			
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
	@Test
	public void verifyQueueOperations(){
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		
		if(!queuePage.isQueuePageOpen()) {
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToQueuePage();
		}
		
		queuePage.clickQueueOperations();
		queuePage.clickTryHereBtn();
		if(queuePage.verifyTryEditorPage()) {
			
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
	
	@Test
	public void verifyPracticeQuestions(){
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		
		if(!queuePage.isQueuePageOpen()) {
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username, password);
			homePage.navigateToQueuePage();
		}
		
		queuePage.clickImpQueueInPython();
		queuePage.clickPracticeQuestions();
		if(queuePage.isInPracticeQuesPage()) {
			
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
}
