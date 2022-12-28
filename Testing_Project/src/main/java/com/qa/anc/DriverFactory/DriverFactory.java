package com.qa.anc.DriverFactory;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	/**
	 * 
	 * @AKshay kumar
	 *
	 */
	public class DriverFactory {
		WebDriver driver;
		Properties prop;
		public static String highlight;
		
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

		/**
		 * This method is used to initialize the webdriver on the basis of given browser
		 * name..
		 * 
		 * @param browserName
		 * @return 
		 */
		public WebDriver init_driver(Properties prop) {
			String browserName = prop.getProperty("browser");
			System.out.println("browser name is :" + browserName);
			
			highlight = prop.getProperty("highlight");
			
			if (browserName.equals("chrome")) {
           	WebDriverManager.chromedriver().setup();
				 System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
				       tlDriver.set(new ChromeDriver()); 
	
				} else if(browserName.equals("firefox")) {
		           	WebDriverManager.chromedriver().setup();
		            tlDriver.set(new FirefoxDriver());	
			}

			else if (browserName.equals("safari")) {
				tlDriver.set(new SafariDriver());

			}
			else {
				System.out.println("Please pass the correct browser name : " + browserName);
			}
			getDriver().manage().window().fullscreen();
			getDriver().manage().deleteAllCookies();
          
          return getDriver();
		}
		
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();
		}
		
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip= new FileInputStream("./src_test_resource/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * take screenshot
	 * @return 
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	}
