package com.dsAlgo.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dsAlgo.base.BaseClass;
import com.dsAlgo.pageObjects.DsAlgoHomePage;
import com.dsAlgo.pageObjects.DsAlgoLoginPage;
import com.dsAlgo.pageObjects.DsAlgoPortalPage;
import com.dsAlgo.utilities.LoggerClass;
import com.dsAlgo.utilities.XLUtility;

public class TC_DsAlgoLoginTest extends BaseClass {
	private DsAlgoHomePage homePage;
	private DsAlgoPortalPage portalPage;
	private DsAlgoLoginPage loginPage;
	private String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestDataDsAlgo.xlsx";
	private XLUtility xlutils = new XLUtility(path);

	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String username,String password, String exp)
	{
		homePage = new DsAlgoHomePage(driver);
		portalPage = new DsAlgoPortalPage(driver);
		loginPage = new DsAlgoLoginPage(driver);
		if(loginPage.isLoginPageOpen())
		{
			loginPage.login(username,password);
		}
		else if (homePage.isHomePageOpen())
		{
			homePage.clickSignIn();
			loginPage.login(username,password);
		}
		else
		{
			portalPage.clickToHome();
			homePage.clickSignIn();
			loginPage.login(username,password);
		}
		
		if(exp.equals("valid"))
		{
			String pageTitle = portalPage.getHomePageTitle();
			if(pageTitle.equals("NumpyNinja"))
			{
				LoggerClass.info("loginTest : Login sucessful");
				loginPage.clickSignOut();
				Assert.assertTrue(true);
			}
			else
			{
				try {
					captureScreen(driver, "loginTest");
				} catch (IOException e) {
					e.printStackTrace();
					LoggerClass.info("loginTest : Login unsucessful");
					Assert.assertTrue(false);
				}
				LoggerClass.info("loginTest : Login unsucessful");
				Assert.assertTrue(false);
			}
		}
		else if(exp.equals("invalid"))
		{
			String pageTitle = portalPage.getHomePageTitle();
			if(pageTitle.equals("NumpyNinja"))
			{
				try {
					captureScreen(driver, "loginTest");
				} catch (IOException e) {
					e.printStackTrace();
					LoggerClass.info("loginTest : Login happen for invalid details");
					loginPage.clickSignOut();
					Assert.assertTrue(false);
				}
				
				loginPage.clickSignOut();
				Assert.assertTrue(false);
			}
			else
			{
				LoggerClass.info("LoginTest : Inavlid login ,Passed");
				Assert.assertTrue(true);
			}
		}
	}
	
	@DataProvider (name ="LoginData")
	public String[][] getData() throws IOException
	{
		int rowCount = xlutils.getRowCount("login");
		int columnCount = xlutils.getColumnCount("login", 1);
		//String loginData[][]= {{"sridevi","Dsalgo@123","valid"},{"bhghhghg","hghghhrewe","invalid"},{"gghhhgbb","mnbvbnhn","invalid"}};
		String loginData[][] = new String[rowCount][columnCount];
		for (int i=1;i<=rowCount;i++)
		{
			for(int j=0; j<columnCount;j++)
			{
				loginData[i-1][j]= xlutils.getCellData("login",i,j);
			}
		}
		return loginData;
	}

}
