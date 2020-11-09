package test.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxDriverInitializer {

    static private final WebDriver webDriver;

    static {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    static public WebDriver getWebDriver(){
        return webDriver;
    }

}
