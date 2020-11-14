package test.lab3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver webDriver;

    static final String pageUrl = "https://www.answers.com";
    static final String topNavigationLinksXPath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[2]/div/a";
    static final String loginButtonXPath = "/html/body/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span/button";
    static final String loginWithEmailButtonXPath = "/html/body/div[3]/div[3]/div/div/div[2]/div/div/button";
    static final String usernameInputXPath = "//*[@id=\"email-input\"]";
    static final String passwordInputXPath = "//*[@id=\"outlined-adornment-password\"]";
    static final String submitButtonXPath = "/html/body/div[3]/div[3]/div/div/form/button";
    static final String loginMenuXPath = "/html/body/div[1]/div/div/div[1]/div[1]/div/div/div[2]/span/button";
    static final String logoutButtonXPath = "/html/body/div[3]/div[3]/ul/li[3]/p/a";
    static final String questionAuthorXPath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[1]/a[2]";
    static final String footerXPath = "/html/body/div[1]/div/div/div[2]/div/div[1]/div/div/li/a";


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(pageUrl);
    }

    public List<String> getTopNavigationBarLinks(){
        List<WebElement> topNavigationBar = webDriver.findElements(By.xpath(topNavigationLinksXPath));
        List<String> links = new ArrayList<>();
        for (int i = 0; i < topNavigationBar.size(); i++)
            links.add(i, topNavigationBar.get(i).getAttribute("href"));
        return links;
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void open(String url){
        webDriver.get(url);
    }

    public Boolean login(String username, String password){
        WebDriverWait wait = new WebDriverWait(webDriver,20);

        webDriver.findElement(By.xpath(loginButtonXPath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginWithEmailButtonXPath)));
        webDriver.findElement(By.xpath(loginWithEmailButtonXPath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(usernameInputXPath)));
        webDriver.findElement(By.xpath(usernameInputXPath)).sendKeys(username);
        webDriver.findElement(By.xpath(passwordInputXPath)).sendKeys(password);

        webDriver.findElement(By.xpath(submitButtonXPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginMenuXPath)));
        return true;
    }

    public String getQuestionAuthor(){
        WebDriverWait wait = new WebDriverWait(webDriver,20);
        webDriver.get(pageUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(questionAuthorXPath)));

        webDriver.findElement(By.xpath(questionAuthorXPath)).click();
        return webDriver.getCurrentUrl();
    }

    public List<String> getFooterLinks(){
        List<WebElement> footerElements = webDriver.findElements(By.xpath(footerXPath));
        List<String> footerLinks = new ArrayList<>();
        List<String> actualFooterLinks = new ArrayList<>();
        for (int i = 0; i < footerElements.size(); i++)
            footerLinks.add(i, footerElements.get(i).getAttribute("href"));
        for (String footerLink: footerLinks){
            webDriver.get(footerLink);
            actualFooterLinks.add(webDriver.getCurrentUrl());
        }
        return actualFooterLinks;
    }

    public Boolean logout(){
        WebDriverWait wait = new WebDriverWait(webDriver,20);

        if (webDriver.findElements(By.xpath(loginMenuXPath)).size() == 0)
            return false;

        webDriver.findElement(By.xpath(loginMenuXPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoutButtonXPath)));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginButtonXPath)));
        webDriver.findElement(By.xpath(logoutButtonXPath)).click();

        return true;
    }

}
