package com.qa.anc.test;

import org.testng.annotations.BeforeClass;

import com.qa.anc.base.BaseTest;

public class RegisteredPW_ViewdetailsTest extends BaseTest {


	@BeforeClass
	
	public void RegisteredPW_ViewdetailsPageSetup() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(5000);
	
	}
}
