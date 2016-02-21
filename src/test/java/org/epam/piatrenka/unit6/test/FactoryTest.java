package org.epam.piatrenka.unit6.test;

import org.epam.piatrenka.unit6.ui.pages.LoginPage;
import org.epam.piatrenka.unit6.webdriver.ChromeDriverCreator;
import org.epam.piatrenka.unit6.webdriver.WebdriverCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FactoryTest {

	
	@Test(description = "factory method test")
	public void facoryTest(){
	WebdriverCreator creator = new ChromeDriverCreator();
	WebDriver driver = creator.factoryMethod();
	driver.navigate().to(LoginPage.EMAIL_URL);
	}
}
