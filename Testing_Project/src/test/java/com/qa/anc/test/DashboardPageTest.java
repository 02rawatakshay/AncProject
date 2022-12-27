package com.qa.anc.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.anc.base.BaseTest;

public class DashboardPageTest extends BaseTest {
	
	@BeforeClass
	
	public void DashboardPageSetup() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test
	public void DashboardPageTest() {
		String DashboardLogo = dashboardPage.getDashboardPageTitle();
		System.out.println("Dashboard Page Logo is " + DashboardLogo );
		Assert.assertEquals(DashboardLogo, "ANCHAL");
}
	@Test
	public void LogoutPwdLinkTest() {
		Assert.assertTrue(dashboardPage.getLogoutPwdLinkExist());
	}
	
	@Test(enabled = false)
	public void DashboardPageHeaderTest() {
		String DashboardHeader = dashboardPage.getDashboardPageHeader();
		System.out.println("Dashboard Page Logo is " + DashboardHeader );
		Assert.assertEquals(DashboardHeader, "ANCHAL- Antenatal Care & Health Awareness for Quality Life\r\n"
				+ "(An initiative by District of Munger Administration)");

}
	@Test
	public void RegisteredPregnantWomenTest() {
		Assert.assertTrue(dashboardPage.isRegisteredPregnantWomen());
	}
	@Test
	public void NumberofCasesatFRUSTest() {
		Assert.assertTrue(dashboardPage.isNumberofCasesatFRUS());
	}
	@Test
	public void NumberofCasesatPHCandCHCTest() {
		Assert.assertTrue(dashboardPage.isNumberofCasesatPHCandCHC());
	}
	@Test
	public void NumberofCasesatAPHCandUPHCTest() {
		Assert.assertTrue(dashboardPage.isNumberofCasesatAPHCandUPHC());
	}
	@Test
	public void NumberofHighRiskCasesofPregnantWomenTest() {
		Assert.assertTrue(dashboardPage.isNumberofHighRiskCasesofPregnantWomen());
	}
	@Test
	public void DueOverDueANCofPregnantWomenTest() {
		Assert.assertTrue(dashboardPage.isDueOverDueANCofPregnantWomen());
	}
	@Test
	public void ListofPregnantWomenwhoseANCsCompletedTest() {
		Assert.assertTrue(dashboardPage.isListofPregnantWomenwhoseANCsCompleted());
	}
	@Test
	public void RegisteredFRUSTest() {
		Assert.assertTrue(dashboardPage.isRegisteredFRUS());
	}
	@Test
	public void RegisteredPHCandCHCTest() {
		Assert.assertTrue(dashboardPage.isRegisteredPHCandCHC());
	}
	@Test
	public void RegisteredAPHCandUPHC() {
		Assert.assertTrue(dashboardPage.isRegisteredAPHCandUPHC());
	}
}
