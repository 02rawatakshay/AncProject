package com.qa.anc.DriverFactory;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
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
				       driver = new ChromeDriver();
	
				} else if(browserName.equals("firefox")) {
		           	WebDriverManager.chromedriver().setup();
					       driver = new FirefoxDriver();		
			}

			else if (browserName.equals("safari")) {
	                  driver = new ChromeDriver();

			}
			else {
				System.out.println("Please pass the correct browser name : " + browserName);
			}
          driver.manage().window().fullscreen();
          driver.manage().deleteAllCookies();
          
          return driver;
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
	
	}
