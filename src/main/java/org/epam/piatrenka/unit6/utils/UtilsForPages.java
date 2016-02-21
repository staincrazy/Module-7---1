package org.epam.piatrenka.unit6.utils;

import org.epam.piatrenka.unit6.ui.pages.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilsForPages extends Page {

	public JavascriptExecutor js = (JavascriptExecutor) driver;

	public UtilsForPages(WebDriver driver) {
		super(driver);

	}

	public void clickButtonByJavaScript(WebElement element) {

		js.executeScript("arguments[0].click();", element);
		//takeScreenshot(driver);
		
	}

	public void highlightByJavaScript(WebDriver driver ,WebElement element) {
	//	String bg = element.getCssValue("backgroundColor ");
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: yellow; border: 10px dotted solid green;");
		takeScreenshot(driver);
	//	js.executeScript("arguments[0].style.backGroundColor ='" + bg + "'", element);
		
	}

}
