package com.dsAlgo.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dsAlgo.base.BaseClass;
import com.dsAlgo.pageObjects.DsAlgoHomePage;
import com.dsAlgo.pageObjects.DsAlgoLoginPage;
import com.dsAlgo.pageObjects.DsAlgoPortalPage;
import com.dsAlgo.utilities.LoggerClass;
import com.dsAlgo.utilities.XLUtility;

public class TC_DsAlgoHomeTest extends BaseClass {

	private DsAlgoHomePage homePage;
	private DsAlgoPortalPage portalPage;
	public static Logger logger;
	private String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestDataDsAlgo.xlsx";
	private XLUtility xlutils = new XLUtility(path);
	@BeforeClass
	public void loggerObj()
	{
		logger=(Logger) LogManager.getLogger();
	}
	
	@BeforeMethod
	public void clients()
	{
		homePage = new DsAlgoHomePage(driver);
		 portalPage = new DsAlgoPortalPage(driver);
	}
	
	@Test
	public void signIn()
	{
		//homePage = new DsAlgoHomePage(driver);
		//portalPage = new DsAlgoPortalPage(driver);
		
		if(homePage.isHomePageOpen())
		{
			homePage.clickSignIn();
		}
		else {
			portalPage.clickToHome();
			homePage.clickSignIn();	
		}

		
		String pageTitle = homePage.getLoginPageTitle();
		homePage.loginToPortalPage();
		
		if(pageTitle.equals("Login"))
		{
			logger.info("In Login Page");
			Assert.assertTrue(true);
		}
		else
		{
			try {
				captureScreen(driver, "signIn");
			} catch (IOException e) {
				e.printStackTrace();
				logger.debug("Not in LoginPage");
				Assert.assertTrue(false);
			}
			logger.debug("Not in LoginPage");
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void verifyRegisterLink()
	{
		//homePage = new DsAlgoHomePage(driver);
		//portalPage = new DsAlgoPortalPage(driver);
		
		if(homePage.isHomePageOpen())
		{
			homePage.clickRegister();
		}
		else {
			portalPage.clickToHome();
			homePage.clickRegister();
		}
		
		
		String pageTitle = homePage.getRegisterPageTitle();
		if(pageTitle.equals("Registration"))
		{
			homePage.registerToPortalPage();
			logger.debug("In Registration Page");
			Assert.assertTrue(true);
		}
		else
		{
			try {
				captureScreen(driver, "verifyRegisterLink");
			} catch (IOException e) {
				e.printStackTrace();
				logger.debug("Not in Registration");
				Assert.assertTrue(false);
			}
			logger.debug("Not in Registration");
			Assert.assertTrue(false);
		}
		
	}
	

	@Test
	public void verifyDropDown() throws IOException {
		//String menuData[] = {"Arrays","Linked List","Stack","Queue","Tree","Graph"};
		
		int rowCount = xlutils.getRowCount("homepage");
		
		List<String> menuData = new ArrayList<String>();
		for (int i=1;i<=rowCount;i++)
		{
				menuData.add(xlutils.getCellData("homepage",i,0));
		}

		
		if(homePage.isHomePageOpen())
		{
			homePage.clickDropDown();
		}
		else {
			portalPage.clickToHome();
			homePage.clickDropDown();
		}
		if(homePage.verifyDropdownMenu(menuData))
		{
			LoggerClass.info("Drop menu is compared and equal");
			Assert.assertTrue(true);
		}
		else
		{
			LoggerClass.info("Drop menu is compared and not equal");
			try {
				captureScreen(driver, "verifyDropDown");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(false);
			
		}
	}
	
	@Test (priority = 1)
	public void verifyArrayPageNav_BeforeLogin()
	{
		if(homePage.isHomePageOpen())
		{
			homePage.navigateToArrayPage();
		}
		else {
			portalPage.clickToHome();
			homePage.navigateToArrayPage();
		}
		
		try {
			captureScreen(driver, "verifyArrayPageNav_BeforeLogin");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(homePage.verifyNotLogginAlertMsg().equals("You are not logged in"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			try {
				captureScreen(driver, "verifyArrayPageNav_BeforeLogin");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(false);
		}
	
	}
	@Test (priority = 2)
	public void verifyArrayPageNav_AfterLogin()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!homePage.isHomePageOpen())
			portalPage.clickToHome();
		
		homePage.clickSignIn();
		loginPage.login(username, password);
		homePage.navigateToArrayPage();
		
		if(homePage.verifyArrayPageHeader())
		{
			homePage.navigateBack();
			homePage.clickSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			try {
				captureScreen(driver, "verifyArrayPageNav_AfterLogin");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(false);
		}
	
	}
	
	@Test
	public void verifyArrayPageNav_FromDropdown()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!homePage.isHomePageOpen())
			portalPage.clickToHome();
		
		homePage.clickSignIn();
		loginPage.login(username, password);
		homePage.clickDropDown();
		homePage.NavigateArrayPageFromDropdownMenu();
		
		if(homePage.verifyArrayPageHeader())
		{
			homePage.navigateBack();
			homePage.clickSignOut();
			logger.info("Navigated to array page");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Not navigated to array page");
			try {
				captureScreen(driver, "verifyRegisterLink");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyQueuePageNav_AfterLogin()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!homePage.isHomePageOpen())
			portalPage.clickToHome();
		
		homePage.clickSignIn();
		loginPage.login(username, password);
		homePage.navigateToQueuePage();
		
		if(homePage.verifyQueuePageHeader())
		{
			homePage.navigateBack();
			homePage.clickSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			try {
				captureScreen(driver, "verifyRegisterLink");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyTreePageNav_AfterLogin()
	{
		DsAlgoLoginPage loginPage = new DsAlgoLoginPage(driver);
		if(!homePage.isHomePageOpen())
			portalPage.clickToHome();
		
		homePage.clickSignIn();
		loginPage.login(username, password);
		homePage.navigateToTreePage();
		
		if(homePage.verifyTreePageHeader())
		{
			homePage.navigateBack();
			homePage.clickSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			try {
				captureScreen(driver, "verifyTreePageNav_AfterLogin");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(false);
		}
	
	}
}
