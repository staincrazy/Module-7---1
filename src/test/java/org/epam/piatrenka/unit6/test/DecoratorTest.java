package org.epam.piatrenka.unit6.test;

import org.epam.piatrenka.unit6.patterns.Decorator;
import org.epam.piatrenka.unit6.ui.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DecoratorTest {

	@Test
	public void decoratorTest() {
		WebDriver driver = new FirefoxDriver();
		driver = new Decorator(driver);
		driver.navigate().to(LoginPage.EMAIL_URL);
		driver.findElement(By.xpath(".//Button[text()='Войти в почту']")).click();

	}

}
