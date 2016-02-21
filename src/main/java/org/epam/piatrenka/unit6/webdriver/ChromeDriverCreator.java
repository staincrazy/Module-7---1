package org.epam.piatrenka.unit6.webdriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeDriverCreator extends WebdriverCreator{

	public static final String PATH_TO_CHROMEDRIVER = "src//main//resources//wd_binaries//chrome//chromedriver.exe";

    @Override
    public WebDriver factoryMethod() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_CHROMEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver(service);
        return driver;
    }
}
