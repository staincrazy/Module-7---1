package org.epam.piatrenka.unit6.ui.pages;

import org.epam.piatrenka.unit6.test.EmailOperatorTest;
import org.epam.piatrenka.unit6.utils.TextXPathGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage extends Page {

	public DraftsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

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

	public boolean messagesPresenceVerifier() {
		logger.debug("debug message test");
		return epmtyDraftsVerifier.isDisplayed();

	}

	public boolean verifyAddress() {
		logger.error("This mesage contains errorTest");
		TextXPathGenerator tg = new TextXPathGenerator();
		tg.setVariablePart(propAddress);
		properAddress = driver.findElement(By.xpath(tg.getFullPath()));
		return properAddress.isDisplayed();
	}

	public boolean verifySubject() {
		logger.trace("Trace message");
		TextXPathGenerator tg = new TextXPathGenerator();
		tg.setVariablePart(propSubject);
		properSubject = driver.findElement(By.xpath(tg.getFullPath()));
		return properSubject.isDisplayed();
	}

	public NewMailPage openSavedEmail() {
		logger.info("Info Message");
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
