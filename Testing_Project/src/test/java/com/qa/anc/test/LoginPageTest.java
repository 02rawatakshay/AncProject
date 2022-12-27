package com.qa.anc.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.anc.base.BaseTest;

public class LoginPageTest extends BaseTest {
		
		@Test
		public void loginPageTitleTest() {
			String title = loginPage.getLoginPageTitle();
			System.out.println("login page title is : " + title);
			Assert.assertEquals(title, "ANCHAL");
		}
		
		@Test
		public void forgotPwdLinkTest() {
			Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		}
		
		@Test
		public void StayloginTest() {
			Assert.assertTrue(loginPage.getstaylogin());
		}

		@Test
		public void loginTest() {
			 loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			
		}
	}
 
