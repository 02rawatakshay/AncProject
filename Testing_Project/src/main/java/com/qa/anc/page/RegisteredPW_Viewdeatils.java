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
	private By RegisteredPWPage = By.xpath("(//a[@type = 'submit'])[1]");
	private By header = By.cssSelector("p.heading");
	private By searchText =  By.xpath("//input[@placeholder='Search by Name']");
	private By searchButton =  By.cssSelector("img.searchIcon.cursorStyle']");
	private By DownloadButton =  By.cssSelector("button.btn.download-btn']");
	private By BackButton =  By.xpath("//button[@class='backButton']");
	private By searchItemResult = By.cssSelector("button.view-btn.ng-star-inserted");
	
	public RegisteredPW_Viewdeatils(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	public boolean getRegisteredPWPage() {
		 elementUtils.doActionsClick(RegisteredPWPage);
		return true ;
	}
	public String getHeaderValue() {
		if(elementUtils.doIsDisplayed(header)) {
			return elementUtils.doGetText(header);
		}
		return null;
	}
	public boolean doSearch(String PWName) {
		elementUtils.doSendKeys(searchText, PWName);
		elementUtils.doClick(searchButton);
		if(elementUtils.getElements(searchItemResult).size() > 0) {
			return true;
		}
		return false;
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