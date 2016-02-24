package org.epam.piatrenka.unit6.test;

import org.epam.piatrenka.unit6.core.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.piatrenka.unit6.userdata.TestUserData;
import org.epam.piatrenka.unit6.ui.pages.DraftsPage;
import org.epam.piatrenka.unit6.ui.pages.LoginPage;
import org.epam.piatrenka.unit6.ui.pages.MainPage;
import org.epam.piatrenka.unit6.ui.pages.NewMailPage;
import org.epam.piatrenka.unit6.ui.pages.SentMessagesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailOperatorTest {

	private WebDriver driver;
	private Logger logger = LogManager.getRootLogger();

	public static String address = "test@email.com";
	public static String subject = "Test Subject";
	private String messageBody = "Test text for message body";

	@BeforeClass(description = "Tests set Up")
	public void setUp() {
		logger.info("Setting up environment");
		driver = new FirefoxDriver();
		driver.get(LoginPage.EMAIL_URL);
	}

	@Test(description = "LoginTest")
	public void loginTest() {
		logger.info("Login testing");
		TestUserData tud = new TestUserData();
		LoginPage lp = new LoginPage(driver);
		lp.setLogin(tud.getLogin());
		lp.setPassword(tud.getPassword());
		MainPage mp = lp.openMainPage();
		Assert.assertTrue(mp.getPageTitle());

	}

	@Test(description = "Main page test", dependsOnMethods = "loginTest")
	public void mainPageTest() {
		logger.info("Main page testing");
		MainPage mp = new MainPage(driver);
		NewMailPage nmp = mp.openNewMailPage();
		Assert.assertNotNull(nmp);
	}

	@Test(description = "New email test", dependsOnMethods = "mainPageTest")
	public void newEmailTest() {
		logger.info("New email composing testing");
		NewMailPage nmp = new NewMailPage(driver);
		nmp.setAddress(address);
		nmp.setSubject(subject);
		nmp.setMessageBody(messageBody);
		nmp.saveMessageAsDraft();
		MainPage mp = nmp.backToMainPage();
		Assert.assertNotNull(mp);

	}

	@Test(description = "Proceed from Main page to Drafts page test", dependsOnMethods = "newEmailTest")
	public void fromMainPageToDraftsTest() {
		logger.info("Proceed from Main page to Drafts page testing");
		MainPage mp = new MainPage(driver);
		DraftsPage dp = mp.openDraftsPage();
		Assert.assertNotNull(dp);

	}

	@Test(description = "Verify new message got to drafts", dependsOnMethods = "fromMainPageToDraftsTest")
	public void verifyMessageInDraftsTest() {
		logger.info("Testing of message get to drafts folder ");
		DraftsPage dp = new DraftsPage(driver);
		Assert.assertTrue(dp.verifyAddress());
		Assert.assertTrue(dp.verifySubject());
		dp.openSavedEmail();

	}

	@Test(description = "Send draft message test", dependsOnMethods = "verifyMessageInDraftsTest")
	public void sendDraftsMessage() {
		logger.info("Testing of sending message from drafts folder");
		NewMailPage nmp = new NewMailPage(driver);
		nmp.sendMessage();
		DraftsPage dp = new DraftsPage(driver);
		Assert.assertTrue(dp.messagesPresenceVerifier());
		nmp.openSentMessagesPage();

	}

	@Test(description = "Verify message got to sent folder", dependsOnMethods = "sendDraftsMessage")
	public void verifyMessageInSentTest() {
		logger.info("testing of message goes to drafts");
		SentMessagesPage smp = new SentMessagesPage(driver);
		Assert.assertTrue(smp.verifyAddress());
		Assert.assertTrue(smp.verifySubject());
	}

	@Test(description = "mailbox cleaner", dependsOnMethods = "verifyMessageInSentTest")
	public void mailboxCleanUp() {
		logger.info("Cleaning meilbox");
		SentMessagesPage smp = new SentMessagesPage(driver);
		try {
			smp.cleanUp();
		} catch (InterruptedException e) {

			throw new CustomException(
					"The implementation of thread.sleep may cause this problem");
		} finally {
			smp.exitMailBox();
		}
	}

	@AfterClass(description = "WebDriver close")
	public void shutDown() {
		logger.info("Closing environment");
		driver.quit();
	}

}
