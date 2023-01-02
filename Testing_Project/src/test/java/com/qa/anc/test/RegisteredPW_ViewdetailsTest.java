package com.qa.anc.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.anc.base.BaseTest;

public class RegisteredPW_ViewdetailsTest extends BaseTest {


	@BeforeClass
	
	public void RegisteredPW_ViewdetailsPageSetup() throws InterruptedException {
		registeredPW_Viewdeatils = loginPage.DoLogin(prop.getProperty("username"), prop.getProperty("password"));
	 Thread.sleep(2000);
	}
	@Test (priority = 1)
	public void getRegisteredPWPageTest() {
		
		Assert.assertTrue(registeredPW_Viewdeatils.getRegisteredPWPage());
		
		
}
	@Test(priority = 3)	
	public void searchTest(String PWName) {
		Assert.assertTrue(registeredPW_Viewdeatils.doSearch(PWName));
	}
	@Test(priority = 4)
	public void getHeaderValueTest() {
		String title = registeredPW_Viewdeatils.getHeaderValue();
		System.out.println("Registered PW page title is: " + title);
		Assert.assertEquals(title, "Registered Pregnant Women");
}
	@Test (priority = 5)
	public void DownloadButtonTest() {
		Assert.assertTrue(registeredPW_Viewdeatils.getDownloadButton());
	}

    @Test (priority = 6)
    public void getBackButtonTest() {
	Assert.assertTrue(registeredPW_Viewdeatils.getBackButton());
}
}