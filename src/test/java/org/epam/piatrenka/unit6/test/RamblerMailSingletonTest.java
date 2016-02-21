package org.epam.piatrenka.unit6.test;

import org.epam.piatrenka.unit6.patterns.WebdriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RamblerMailSingletonTest {
	
	@Test(description = "Test if mail server available")
	public void testRamblerEmail(){
		WebDriver driver = WebdriverSingleton.getInstance();
		driver.get("mail.rambler.ru");
	}

}
