package org.epam.piatrenka.unit6.patterns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverSingleton {
	
	private static WebDriver driver;
	
	private WebdriverSingleton(){}
	
	public static WebDriver getInstance(){
		if (null == driver) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void closeDriver(){
		driver.quit();
		driver = null;
	}

}
