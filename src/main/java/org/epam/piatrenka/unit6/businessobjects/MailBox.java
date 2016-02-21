package org.epam.piatrenka.unit6.businessobjects;

import org.epam.piatrenka.unit6.ui.pages.DraftsPage;
import org.epam.piatrenka.unit6.ui.pages.LoginPage;
import org.epam.piatrenka.unit6.ui.pages.MainPage;
import org.epam.piatrenka.unit6.ui.pages.NewMailPage;
import org.epam.piatrenka.unit6.ui.pages.SentMessagesPage;
import org.openqa.selenium.WebDriver;

public class MailBox {

	private String url;
	private WebDriver driver;
	private String Description = "Main use case";

	public void setUrl(String ouuterUrl) {
		url = ouuterUrl;
		System.out.println(url);

	}

	public void objectNotice() {
		System.out.println(Description);
	}

	public void openMailBox() {
		LoginPage lp = new LoginPage(driver);
		lp.setLogin("");
		lp.setPassword("");
		lp.openMainPage();

	}

	public void mainPageOperations() {
		MainPage mp = new MainPage(driver);
		mp.getPageTitle();
		mp.openDraftsPage();
		mp.openNewMailPage();
	}

	public void newMailPage() {
		NewMailPage nmp = new NewMailPage(driver);
		nmp.backToMainPage();
		nmp.setAddress("");
		nmp.setSubject("");
		nmp.setMessageBody("");
		nmp.sendMessage();
		nmp.saveMessageAsDraft();
		nmp.openSentMessagesPage();

	}

	public void draftsMailPage() {
		DraftsPage dp = new DraftsPage(driver);
		dp.cleanUp();
		dp.messagesPresenceVerifier();
		dp.verifyAddress();
		dp.verifySubject();
		dp.openSavedEmail();
	}

	public void sentMessagesPage() {
		SentMessagesPage smp = new SentMessagesPage(driver);
		smp.verifySubject();
		smp.verifyAddress();
		smp.exitMailBox();
	}

}
