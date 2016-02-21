package org.epam.piatrenka.unit6.ui.pages;

import org.epam.piatrenka.unit6.utils.UtilsForPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

	public static final String EMAIL_URL = "http://www.mail.rambler.ru";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(xpath = ".//*[@name='login']")
	public WebElement loginField;

	@FindBy(xpath = ".//*[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = ".//Button[text()='Войти в почту']")
	private WebElement loginButton;

	public LoginPage setLogin(String login) {
		logger.info("Filling login");
		loginField.sendKeys(login);
		return this;
	}

	public LoginPage setPassword(String password) {
		logger.info("Filling password");
		passwordField.sendKeys(password);
		return this;
	}

	public MainPage openMainPage() {
		logger.warn("Verify Main Page created");
		UtilsForPages ufp = new UtilsForPages(driver);
		ufp.highlightByJavaScript(driver, loginButton);
		loginButton.click();
		return PageFactory.initElements(driver, MainPage.class);
		
	}
	
	

}
