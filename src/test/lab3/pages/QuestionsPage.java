package test.lab3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuestionsPage extends HomePage {

    final static String createQuestionButtonXPath = "/html/body/div[1]/div/div/div[1]/div[1]/div/div/div[2]/button";
    final static String questionTextFieldXPath = "/html/body/div[3]/div[3]/div/div[2]/div[1]/div/textarea";
    final static String questionSubmitXPath = "/html/body/div[3]/div[3]/div/div[2]/button[2]";
    final static String questionAuthorXPath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/a[2]";
    final static String answerQuestionButtonXPath = "/html/body/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div/button";
    final static String answerTextFieldXPath = "/html/body/div[3]/div[3]/div/div[2]/div[1]/div[1]/div[2]/div";
    final static String answerSubmitXPath = "/html/body/div[3]/div[3]/div/div[2]/button";

    public QuestionsPage(WebDriver webDriver) {
        super(webDriver);
        login("trshmil", "3MUrSKK6EDbj4sN");
    }

    public String createQuestion(String text){
        WebDriverWait wait = new WebDriverWait(webDriver,10);

        webDriver.findElement(By.xpath(createQuestionButtonXPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createQuestionButtonXPath)));

        webDriver.findElement(By.xpath(questionTextFieldXPath)).sendKeys(text);
        webDriver.findElement(By.xpath(questionSubmitXPath)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerQuestionButtonXPath)));
        return webDriver.getCurrentUrl();
    }

    public boolean answerQuestion(String questionUrl, String text) {
        webDriver.get(questionUrl);

        WebDriverWait wait = new WebDriverWait(webDriver,10);

        webDriver.findElement(By.xpath(answerQuestionButtonXPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerTextFieldXPath)));
        webDriver.findElement(By.xpath(answerTextFieldXPath)).click();
        webDriver.findElement(By.xpath(answerTextFieldXPath)).sendKeys(text);
        webDriver.findElement(By.xpath(answerSubmitXPath)).click();

        return true;
    }

    public String getQuestionAuthor(String questionUrl){
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        webDriver.get(questionUrl);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(questionAuthorXPath)));
        webDriver.findElement(By.xpath(questionAuthorXPath)).click();

        return webDriver.getCurrentUrl();
    }

}
