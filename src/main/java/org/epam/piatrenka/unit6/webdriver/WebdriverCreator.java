package org.epam.piatrenka.unit6.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class WebdriverCreator {

	protected WebDriver driver;

	public abstract WebDriver factoryMethod();
}
