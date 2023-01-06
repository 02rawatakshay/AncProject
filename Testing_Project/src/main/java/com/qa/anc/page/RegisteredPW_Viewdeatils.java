package com.qa.anc.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.anc.utils.ElementUtils;

public class RegisteredPW_Viewdeatils{

	private WebDriver driver;
	private ElementUtils elementUtils;
	//1. By Locator / OR
	private By RegisteredPWPage = By.xpath("(//a[@class='common-detail'])[1]");
	private By header = By.xpath("//p[@class='heading']");
	private By searchText =  By.xpath("//input[@placeholder='Search']");
	private By searchButton =  By.xpath("//img[@class='searchIcon cursorStyle']");
	private By DownloadButton =  By.xpath("//button[@class='btn download-btn']");
	private By BackButton =  By.xpath("//button[@class='backButton']");
	private By searchItemResult = By.xpath("(//tr[@class='mat-row cdk-row ng-star-inserted']"
			+ "//button[@class='view-btn ng-star-inserted'])[1]");
	
	public RegisteredPW_Viewdeatils(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	public boolean getRegisteredPWPage() {
		 elementUtils.doClick(RegisteredPWPage);
		return true ;
	}
	public String getHeaderValue() {
		if(elementUtils.doIsDisplayed(header)) {
			return elementUtils.doGetText(header);
		}
		return null;
	}
	public boolean getdoSearch(String Ritu) {
		elementUtils.doSendKeys(searchText, Ritu);
		elementUtils.doClick(searchButton);
		elementUtils.doClick(searchItemResult);
			return true;	
	}
	public boolean getDownloadButton() {
		return elementUtils.doIsDisplayed(DownloadButton);
}
	public boolean getBackButton() {
		return elementUtils.doIsDisplayed(BackButton);
}

	public DashboardPage selectPWFromResults(String PWName) {
		List<WebElement> resultItemsList = elementUtils.getElements(RegisteredPWPage);
		System.out.println("total number of items displayed : " + resultItemsList.size());
		
		for(WebElement e : resultItemsList) {
			if(e.getText().equals(PWName)) {
				e.click();
				break;
			}
		}
		
		return new DashboardPage(driver);
	}
}