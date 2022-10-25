package com.dsAlgo.testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dsAlgo.base.BaseClass;
import com.dsAlgo.pageObjects.DsAlgoArrayPage;
import com.dsAlgo.pageObjects.DsAlgoHomePage;
import com.dsAlgo.pageObjects.DsAlgoLoginPage;
import com.dsAlgo.pageObjects.DsAlgoPortalPage;
import com.dsAlgo.pageObjects.DsAlgoQueuePage;

public class TC_DsAlgoArrayTest extends BaseClass{
	
	private DsAlgoHomePage homePage;
	private DsAlgoPortalPage portalPage;
	private DsAlgoQueuePage queuePage;
	private DsAlgoArrayPage arrayPage;
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
		arrayPage = new DsAlgoArrayPage(driver);
	}
	
	@Test
	public void testArray()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		portalPage.clickToHome();
		homePage.clickSignIn();
		loginPage.login(username, password);
		homePage.navigateToArrayPage();
		if(arrayPage.arraytest())
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
}
