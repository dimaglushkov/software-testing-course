package test.lab3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverInitializer {

    static private final WebDriver webDriver;

    static {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        webDriver = new ChromeDriver();
    }

    static public WebDriver getWebDriver(){
        return webDriver;
    }

}
