package org.epam.piatrenka.unit6.ui.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class Page {

	protected String PAGE_TITLE;
	
	protected Logger logger = LogManager.getRootLogger();

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public void takeScreenshot(WebDriver driver) {

		File screenshotDir = new File("./test-output/screenshots");

		if (!screenshotDir.exists()) {
			System.out.println("Creating directory: " + screenshotDir);
			boolean result = false;

			try {
				screenshotDir.mkdir();
				result = true;
			} catch (SecurityException se) {
			}
			if (result) {
				System.out
						.println("Screenshots directory was successfully created");
			}
		}

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-a");
		String formattedDate = sdf.format(date);

		String fileName = "screenshot-" + formattedDate;
		try {
			FileUtils.copyFile(
					scrFile,
					new File(String.format("./test-output/screenshots/%s.png",
							fileName)));
			System.out.println(String.format("%s.png was successfully taken",
					fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
