package org.epam.piatrenka.unit6.ui.pages;

import org.epam.piatrenka.unit6.test.EmailOperatorTest;
import org.epam.piatrenka.unit6.utils.TextXPathGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage extends Page {

	private static String propAddress = EmailOperatorTest.address;
	private static String propSubject = EmailOperatorTest.subject;
	private WebElement properAddress;
	private WebElement properSubject;

	@FindBy(xpath = ".//*[text()='Писем нет']")
	private WebElement epmtyDraftsVerifier;

	@FindBy(xpath = ".//*[contains(@class,'uiComboCheckbox')]")
	private WebElement selectAllCheckBox;

	@FindBy(xpath = ".//*[text()='Удалить']")
	private WebElement deleteButton;

	public DraftsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean messagesPresenceVerifier() {
		logger.info("verifying message is disaplyed");
		return epmtyDraftsVerifier.isDisplayed();

	}

	public boolean verifyAddress() {
		logger.info("Verifying address");
		TextXPathGenerator tg = new TextXPathGenerator();
		tg.setVariablePart(propAddress);
		properAddress = driver.findElement(By.xpath(tg.getFullPath()));
		return properAddress.isDisplayed();
	}

	public boolean verifySubject() {
		logger.info("Verifying subject");
		TextXPathGenerator tg = new TextXPathGenerator();
		tg.setVariablePart(propSubject);
		properSubject = driver.findElement(By.xpath(tg.getFullPath()));
		return properSubject.isDisplayed();
	}

	public NewMailPage openSavedEmail() {
		logger.info("Verifying opening of new email page");
		properAddress.click();
		return PageFactory.initElements(driver, NewMailPage.class);
	}

	public DraftsPage cleanUp() {
		logger.warn("Verify Factory Methods");
		selectAllCheckBox.click();
		deleteButton.click();
		return this;
	}

}
