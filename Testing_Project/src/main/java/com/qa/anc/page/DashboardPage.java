package com.qa.anc.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.anc.utils.ElementUtils;


public class DashboardPage{
	
	private WebDriver driver;
	private ElementUtils elementUtils;

	//1. By Locator / OR
	
	private By Dashboardheader = By.xpath("//p[@class='dashboard-text']");
	private By LogoutPwdLink = By.xpath("//span[@class='logoutText cursorStyle me-2']");
	private By RegisteredPregnantWomen = By.xpath("(//div[@class='standard-div']/p)[1]");
	private By NumberofCasesatFRUS = By.xpath("(//div[@class='standard-div']/p)[2]");
	private By NumberofCasesatPHCandCHC = By.xpath("(//div[@class='standard-div']/p)[3]");
	private By NumberofCasesatAPHCandUPHC = By.xpath("(//div[@class='standard-div']/p)[4]");
	private By NumberofHighRiskCasesofPregnantWomen = By.xpath("(//div[@class='dashboard-reports-card view-details-card-p1'])[1]");
	private By DueOverDueANCofPregnantWomen = By.xpath("(//div[@class='dashboard-reports-card view-details-card-p1'])[2]");
	private By ListofPregnantWomenwhoseANCsCompleted = By.xpath("(//div[@class='dashboard-reports-card view-details-card-p1'])[3]");
	private By RegisteredFRUS = By.xpath("(//span[@class='dashboard-counts-above-footer-text'])[1]");
	private By RegisteredPHCandCHC = By.xpath("(//span[@class='dashboard-counts-above-footer-text'])[2]");
	private By RegisteredAPHCandUPHC = By.xpath("(//span[@class='dashboard-counts-above-footer-text'])[3]");
		
	
	//2. Constructor of page class:
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;	
		elementUtils = new ElementUtils(this.driver);
		
}		

    public String getDashboardPageTitle() {
	     return  elementUtils.waitForPageTitlePresent(getDashboardPageHeader(), 5);
}
    public boolean getLogoutPwdLinkExist() {
		return elementUtils.doIsDisplayed(Dashboardheader);
	}
    
	public String getDashboardPageHeader() {
		if(elementUtils.doIsDisplayed(Dashboardheader)) {
			return elementUtils.doGetText(Dashboardheader);
		}
		return null;	
}
	
	public boolean isRegisteredPregnantWomen() {	
		return elementUtils.doIsDisplayed(RegisteredPregnantWomen);
		
}
	public boolean isNumberofCasesatFRUS() {
		return elementUtils.doIsDisplayed(NumberofCasesatFRUS);
		
		
	}
	public boolean isNumberofCasesatPHCandCHC() {	
		return elementUtils.doIsDisplayed(NumberofCasesatPHCandCHC);
		
}
	public boolean isNumberofCasesatAPHCandUPHC() {
		return elementUtils.doIsDisplayed(NumberofCasesatAPHCandUPHC);
		
}
  public boolean isNumberofHighRiskCasesofPregnantWomen() {
	return elementUtils.doIsDisplayed(NumberofHighRiskCasesofPregnantWomen);
	
}
  public boolean isDueOverDueANCofPregnantWomen() {
		return elementUtils.doIsDisplayed(DueOverDueANCofPregnantWomen);
		
	}
  public boolean isListofPregnantWomenwhoseANCsCompleted() {
		return elementUtils.doIsDisplayed(ListofPregnantWomenwhoseANCsCompleted);
		
	}
  public boolean isRegisteredFRUS() {
	  return elementUtils.doIsDisplayed(RegisteredFRUS);
		
	}
  public boolean isRegisteredPHCandCHC() {
	  return elementUtils.doIsDisplayed(RegisteredPHCandCHC);
		
	}
  public boolean isRegisteredAPHCandUPHC() {
	  return elementUtils.doIsDisplayed(RegisteredAPHCandUPHC);
		
	}
}