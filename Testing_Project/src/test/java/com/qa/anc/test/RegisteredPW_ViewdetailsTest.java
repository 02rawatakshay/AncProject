package com.qa.anc.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.anc.base.BaseTest;

public class RegisteredPW_ViewdetailsTest extends BaseTest {
	@BeforeClass
	
	public void RegisteredPW_ViewdetailsPageSetup() throws InterruptedException {
		registeredPW_Viewdeatils = loginPage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));
	 Thread.sleep(5000);
	}
	@Test (priority = 1)
	public void getRegisteredPWPageTest() {			
		Assert.assertTrue(registeredPW_Viewdeatils.getRegisteredPWPage());		
		
}
	@Test(priority = 2)	
	public void PWInfoPageTest() throws InterruptedException {
		registeredPW_Viewdeatils.getdoSearch("Ritu");
		Thread.sleep(5000);
		Assert.assertEquals(registeredPW_Viewdeatils.getdoSearch("Ritu"), "Ritu");	
	}
	@Test(priority = 3)
	public void getHeaderValueTest() {
		String title = registeredPW_Viewdeatils.getHeaderValue();
		System.out.println("Registered PW page title is: " + title);
		Assert.assertEquals(title, "Registered Pregnant Women");
}
	@Test (priority = 4)
	public void DownloadButtonTest() {
		Assert.assertTrue(registeredPW_Viewdeatils.getDownloadButton());
	}

    @Test (priority = 5)
    public void getBackButtonTest() {
	Assert.assertTrue(registeredPW_Viewdeatils.getBackButton());
}
}