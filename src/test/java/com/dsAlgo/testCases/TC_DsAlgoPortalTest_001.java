

package com.dsAlgo.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dsAlgo.base.BaseClass;
import com.dsAlgo.pageObjects.DsAlgoPortalPage;

public class TC_DsAlgoPortalTest_001 extends BaseClass {

	DsAlgoPortalPage portalPage;
	public static Logger logger;
	@BeforeClass
	public void logggg()
	{
		logger=(Logger) LogManager.getLogger();
	}
	
	@Test
	public void getStartedToHome()
	{
		portalPage = new DsAlgoPortalPage(driver);
		portalPage.clickToHome();
		
		String pageTitle = portalPage.getHomePageTitle();
		if(pageTitle.equals("NumpyNinja"))
		{
			logger.info("In HomePage");
			Assert.assertTrue(true);
		}
		else
		{
			try {
				captureScreen(driver, "getStartedToHome");
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("Not in HomePage");
				Assert.assertTrue(false);
			}
			logger.info("Not in HomePage");
			Assert.assertTrue(false);
		}
	}
	
}
