package org.epam.piatrenka.unit6.ui.pages;

import org.epam.piatrenka.unit6.core.CustomException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

	@FindBy(xpath = ".//Button[@title='Написать письмо']")
	private WebElement newMailButton;

	@FindBy(xpath = ".//*[text()='Черновики']")
	private WebElement openDraftsButton;

	@FindBy(xpath = ".//*[text()='Входящие']")
	private WebElement assertSuccesfullLogIn;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public NewMailPage openNewMailPage() {
		constructorTest();
		newMailButton.click();
		return PageFactory.initElements(driver, NewMailPage.class);
	}

	public boolean getPageTitle() {
		assertSuccesfullLogIn.isDisplayed();
		return this != null;
	}

	public DraftsPage openDraftsPage() {

		openDraftsButton.click();
		return PageFactory.initElements(driver, DraftsPage.class);

	}

	private MainPage constructorTest() {
		if (MainPage.class == null) {
			logger.debug("Verify page initiation");
			throw new CustomException("Verify class constructor"
					+ MainPage.class);
		}
		return this;
	}

}
