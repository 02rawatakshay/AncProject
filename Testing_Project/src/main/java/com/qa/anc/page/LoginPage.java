package com.qa.anc.page;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

import com.qa.anc.utils.ElementUtils;


	public class LoginPage {
		
		private WebDriver driver;
		private ElementUtils elementUtils;
		
		//1. By Locator / OR
		private By username = By.xpath("//input[@formcontrolname='username']");
		private By password = By.xpath("//input[@formcontrolname='password']");
		private By loginButton = By.xpath("//div//button[@type='submit']");
		private By staylogin = By.xpath("//div[@class='col-6 col-md-7']/label");
		private By ForgotPwdLink = By.xpath("//div[@class='col-md-5 text-end']/a");
		
		//2. Constructor of page class:
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			elementUtils = new ElementUtils(this.driver);
			
		}		

		public String getLoginPageTitle() {
			return elementUtils.waitForPageTitlePresent(getLoginPageTitle(), 5);
		}
		public boolean getstaylogin() {
			return elementUtils.doIsDisplayed(staylogin);
		
			
	}
		public boolean isForgotPwdLinkExist() {
			return elementUtils.doIsDisplayed(ForgotPwdLink);
		}
		
		public DashboardPage doLogin(String un , String pwd) {
			System.out.println("Login with : " + un + " " + pwd);
			elementUtils.doSendKeys(username, un);
			elementUtils.doSendKeys(password, pwd);
			elementUtils.doClick(staylogin);
			elementUtils.doClick(loginButton);
			
			return new DashboardPage(driver);
		
	}
		public RegisteredPW_Viewdeatils DoLogin(String un , String pwd) {
			System.out.println("Login with : " + un + " " + pwd);
			elementUtils.doSendKeys(username, un);
			elementUtils.doSendKeys(password, pwd);
			elementUtils.doClick(staylogin);
			elementUtils.doClick(loginButton);
			
			return new RegisteredPW_Viewdeatils(driver);

}}
