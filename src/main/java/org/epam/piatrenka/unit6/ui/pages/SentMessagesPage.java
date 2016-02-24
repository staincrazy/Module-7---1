package org.epam.piatrenka.unit6.ui.pages;

import org.epam.piatrenka.unit6.test.EmailOperatorTest;
import org.epam.piatrenka.unit6.utils.TextXPathGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentMessagesPage extends Page {

	private static String propAddress = EmailOperatorTest.address;
	private static String propSubject = EmailOperatorTest.subject;
	private WebElement properAddress;
	private WebElement properSubject;

	@FindBy(xpath = ".//*[text()='Reanold']")
	private WebElement openMenuButton;

	@FindBy(xpath = ".//*[text()='Выйти']")
	private WebElement logOffButton;

	@FindBy(xpath = ".//*[contains(@class,'uiComboCheckbox')]")
	private WebElement selectAllCheckBox;

	@FindBy(xpath = ".//Button[@title='Удалить']")
	private WebElement deleteButton;

	public SentMessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean verifyAddress() {
		TextXPathGenerator tg = new TextXPathGenerator();
		tg.setVariablePart(propAddress);
		properAddress = driver.findElement(By.xpath(tg.getFullPath()));
		return properAddress.isDisplayed();
	}

	public boolean verifySubject() {
		TextXPathGenerator tg = new TextXPathGenerator();
		tg.setVariablePart(propSubject);
		properSubject = driver.findElement(By.xpath(tg.getFullPath()));
		return properSubject.isDisplayed();
	}

	public SentMessagesPage exitMailBox() {
		openMenuButton.click();
		logOffButton.click();
		return this;
	}

	public SentMessagesPage cleanUp() throws InterruptedException {
		selectAllCheckBox.click();

		if (deleteButton.isDisplayed()) {
			deleteButton.click();

		} else {
			Thread.sleep(5000);
			deleteButton.click();
		}
		return this;
	}
}
