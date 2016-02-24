package org.epam.piatrenka.unit6.ui.pages;

import org.epam.piatrenka.unit6.utils.UtilsForPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMailPage extends Page {

	protected String messageBodyFrame = "composeEditor_ifr";

	@FindBy(xpath = ".//*[@class='uiAutocompletePlaceholder']")
	private WebElement addressField;

	@FindBy(xpath = ".//*[@id='subject']")
	private WebElement subjectField;

	@FindBy(xpath = ".//*[@id='tinymce']")
	private WebElement messageBodyField;

	@FindBy(xpath = ".//*[@title='Сохранить письмо как черновик']")
	private WebElement saveAsDraftButton;

	@FindBy(xpath = ".//*[text()='К письмам']")
	private WebElement backToMainPageButton;

	@FindBy(xpath = "//html[@id='js']/body/div[7]/div/div/div/div[2]/button[5]")
	private WebElement sendMessageButton;

	@FindBy(xpath = ".//*[text()='Отправленные']")
	private WebElement openSentMessagesButton;

	public NewMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public NewMailPage setAddress(String address) {
		addressField.sendKeys(address);
		return this;
	}

	public NewMailPage setSubject(String subject) {
		subjectField.sendKeys(subject);
		return this;
	}

	private void switchToMessageBodyFrame() {
		driver.switchTo().frame(messageBodyFrame);

	}

	private void switchToDefaultFrame() {
		driver.switchTo().defaultContent();

	}

	public NewMailPage setMessageBody(String messageBody) {

		switchToMessageBodyFrame();
		messageBodyField.sendKeys(messageBody);
		return this;
	}

	public NewMailPage saveMessageAsDraft() {

		switchToDefaultFrame();
		saveAsDraftButton.click();
		return this;
	}

	public MainPage backToMainPage() {
		backToMainPageButton.click();
		return PageFactory.initElements(driver, MainPage.class);

	}

	public NewMailPage sendMessage() {
		UtilsForPages ufp = new UtilsForPages(driver);
		ufp.clickButtonByJavaScript(sendMessageButton);
		return this;

	}

	public SentMessagesPage openSentMessagesPage() {
		openSentMessagesButton.click();
		return PageFactory.initElements(driver, SentMessagesPage.class);

	}

}
