package com.dsAlgo.testCases;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.Random;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dsAlgo.base.BaseClass;
import com.dsAlgo.pageObjects.DsAlgoHomePage;
import com.dsAlgo.pageObjects.DsAlgoPortalPage;
import com.dsAlgo.pageObjects.DsAlgoQueuePage;
import com.dsAlgo.pageObjects.DsAlgoRegisterPage;
import com.dsAlgo.utilities.LoggerClass;
import com.dsAlgo.utilities.XLUtility;

public class TC_DsAlgoRegisterTest extends BaseClass{
	private DsAlgoHomePage homePage;
	private DsAlgoPortalPage portalPage;
	private DsAlgoRegisterPage registerPage;
	String path = System.getProperty("user.dir")+"/src/test/resources/TestData/TestDataDsAlgo.xlsx";
	private XLUtility xlutils = new XLUtility(path);
	
	@BeforeMethod
	public void clients()
	{
		homePage = new DsAlgoHomePage(driver);
		portalPage = new DsAlgoPortalPage(driver);
		registerPage = new DsAlgoRegisterPage(driver);
	}
	
	@DataProvider (name = "registerData")
	public String[][] registrationData() throws IOException
	{
		int rowCount = xlutils.getRowCount("register");
		int colCount = xlutils.getColumnCount("register", 1);
		String regData[][] = new String[rowCount][colCount];
		for (int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				regData[i-1][j]=xlutils.getCellData("register", i, j);
			}
		}
		return regData;
	}
	
	@Test (dataProvider = "registerData")
	public void registerTest(String username, String pwd, String confirmPwd, String exp)
	{
		
		if(homePage.isHomePageOpen())
		{
			homePage.clickRegister();
			registerPage.registration(username, pwd, confirmPwd);
		}
		else if(registerPage.isInRegisterPage())
		{
			registerPage.registration(username, pwd, confirmPwd);
		}
		else {
			portalPage.clickToHome();
			homePage.clickRegister();
			registerPage.registration(username, pwd, confirmPwd);
		}
		
		if(exp.equals("valid"))
		{
			if(registerPage.isInHomePage())
			{
				LoggerClass.info("registerTest : in Home Page");
				if(homePage.isNewAccountCreated())
				{
					LoggerClass.info("New Account created, Username : "+username);
					homePage.clickSignOut();
					Assert.assertTrue(true);
				}
				else
				{
					try {
						captureScreen(driver,"registerTest");
					} catch (IOException e) {
						e.printStackTrace();
					}
					Assert.assertTrue(false);
				}
			}
			else if(registerPage.isInRegisterPage())
			{
				LoggerClass.info("registerTest : In registraion page");
				try {
					captureScreen(driver, "registerTest");
				} catch (IOException e) {
					e.printStackTrace();
					if(registerPage.alertMsg())
						Assert.assertTrue(false);
				}
				if(registerPage.alertMsg())
					Assert.assertTrue(false);
			}
		}
		else if(exp.equals("invalid"))
		{
			if(registerPage.isInRegisterPage())
			{
				LoggerClass.info("registerTest : In registraion page");
				if(registerPage.alertMsg())
					Assert.assertTrue(true);
			}
			else
			{
				try {
					captureScreen(driver,"registerTest");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Assert.assertTrue(false);
			}
		}
	}
	
	@Test
	public void verifyValidRegisterDetails()
	{
		Random number = new Random();
		int num = number.nextInt();
				String username = randomUsername+num;
				System.out.println("randomUsername :"+username);
		if(homePage.isHomePageOpen())
		{
			homePage.clickRegister();
			registerPage.registration(username, password, password);
		}
		else if(registerPage.isInRegisterPage())
		{
			registerPage.registration(username, password, password);
		}
		else {
			portalPage.clickToHome();
			homePage.clickRegister();
			registerPage.registration(username, password, password);
		}

		if(registerPage.isInHomePage())
		{
			LoggerClass.info("registerTest : in Home Page");
			if(homePage.isNewAccountCreated())
			{
				LoggerClass.info("New Account created, Username : "+username);
				homePage.clickSignOut();
				Assert.assertTrue(true);
			}
			else
			{
				try {
					captureScreen(driver,"registerTest");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Assert.assertTrue(false);
			}
		}
		else if(registerPage.isInRegisterPage())
		{
			LoggerClass.info("registerTest : In registraion page");
			try {
				captureScreen(driver, "registerTest");
			} catch (IOException e) {
				e.printStackTrace();
				if(registerPage.alertMsg())
					Assert.assertTrue(false);
			}
			if(registerPage.alertMsg())
				Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void VerifyRegisterWithEmptyFields()
	{
		String username ="";
		String pwd = "";
		String confirmPwd = "";
		if(homePage.isHomePageOpen())
		{
			homePage.clickRegister();
			registerPage.registration(username, pwd, confirmPwd);
		}
		else if(registerPage.isInRegisterPage())
		{
			registerPage.registration(username, pwd, confirmPwd);
		}
		else {
			portalPage.clickToHome();
			homePage.clickRegister();
			registerPage.registration(username, pwd, confirmPwd);
		}
		
		if(registerPage.validationMsgEmptyFields())
			Assert.assertTrue(true);
		else
		{
			try {
				captureScreen(driver,"registerTest");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.assertTrue(false);
			}
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void verifyvalidationMsg()
	{
		if(homePage.isHomePageOpen())
		{
			homePage.clickRegister();
			registerPage.registration(username, password, password);
		}
		else if(registerPage.isInRegisterPage())
		{
			registerPage.registration(username, password, password);
		}
		else {
			portalPage.clickToHome();
			homePage.clickRegister();
			registerPage.registration(username, password, password);
		}
		
		if(registerPage.isInHomePage())
		{
			LoggerClass.info("registerTest : in Home Page");
			if(homePage.isNewAccountCreated())
			{
				LoggerClass.info("New Account created, Username : "+username);
				homePage.clickSignOut();
				Assert.assertTrue(true);
			}
			else
			{
				try {
					captureScreen(driver,"verifyvalidationMsg");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Assert.assertTrue(false);
			}
		}
		else if(registerPage.isInRegisterPage())
		{
			LoggerClass.info("registerTest : In registraion page");
				if(registerPage.alertMsgAlreadyRegistered())
					Assert.assertTrue(true);
				else
				{
					try {
						captureScreen(driver, "verifyvalidationMsg");
					} catch (IOException e) {
						e.printStackTrace();
						Assert.assertTrue(false);
					}
					Assert.assertTrue(false);
				}
		}	
		
	}
}
