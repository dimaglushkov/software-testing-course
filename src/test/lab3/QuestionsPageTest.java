package test.lab3;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.WebElement;
import test.lab3.pages.ChromeDriverInitializer;
import test.lab3.pages.FirefoxDriverInitializer;
import test.lab3.pages.QuestionsPage;

import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionsPageTest {

    static QuestionsPage firefoxHomePage;
    static QuestionsPage chromeHomePage;

    String latestQuestion = "https://www.answers.com/Q/What-a-beautiful-day";

    @BeforeAll
    static void setup() {
        firefoxHomePage = new QuestionsPage(FirefoxDriverInitializer.getWebDriver());
//        chromeHomePage = new QuestionsPage(ChromeDriverInitializer.getWebDriver());
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void answerQuestionTest(QuestionsPage page) {
        String questionText = "Agreed with this statement " + new Random().nextInt(1000) + " have a nice day";
        page.answerQuestion(latestQuestion, questionText);
        assertNotEquals("https://www.answers.com", latestQuestion);
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void createQuestionTest(QuestionsPage page) {
        String questionText = "What a beautiful day " + new Random().nextInt(1000);
        String latestQuestion = page.createQuestion(questionText);
        assertNotEquals("https://www.answers.com", latestQuestion);
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void getQuestionAuthorTest(QuestionsPage page) {
        assertEquals("https://www.answers.com/u/trshmil", page.getQuestionAuthor(latestQuestion));
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void onlineEditorTextFormattingTest(QuestionsPage page) {
        WebElement editor = page.getOnlineEditor(latestQuestion);
        WebElement boldButton = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[3]/span[1]");
        WebElement underlinedButton = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[3]/span[2]");
        WebElement italicButton = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[3]/span[3]");
        editor.sendKeys("first row(normal)\n");

        boldButton.click();
        editor.sendKeys("second row(bold)\n");
        boldButton.click();

        underlinedButton.click();
        editor.sendKeys("third row(underlined)\n");
        underlinedButton.click();

        italicButton.click();
        editor.sendKeys("fourth row(italic)\n");
        italicButton.click();

        boldButton.click();
        underlinedButton.click();
        italicButton.click();
        editor.sendKeys("fifth row(all)");
        italicButton.click();


        WebElement boldRow = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/div/span");
        WebElement underlinedRow = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/div[3]/div/span");
        WebElement italicRow = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/div[4]/div/span");
        WebElement allRow = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/div[5]/div/span");

        assertTrue(boldRow.getAttribute("style").contains("bold"));
        assertTrue(underlinedRow.getAttribute("style").contains("underline"));
        assertTrue(italicRow.getAttribute("style").contains("italic"));
        assertTrue(allRow.getAttribute("style").contains("bold")
                && allRow.getAttribute("style").contains("underline")
                && allRow.getAttribute("style").contains("italic"));
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void onlineEditorListsTest(QuestionsPage page) {
        WebElement editor = page.getOnlineEditor(latestQuestion);
        WebElement numberedListButton = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[3]/span[4]");
        WebElement checkListButton = page.find("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[3]/span[5]");

        numberedListButton.click();
        editor.sendKeys("first numbered row\nsecond numbered row");
        assertEquals(2, page.findElements("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/ol/li").size());

        editor.sendKeys("\n");
        numberedListButton.click();

        checkListButton.click();
        editor.sendKeys("first checked row\nsecond checked row");
        assertEquals(2, page.findElements("/html/body/div[3]/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/ul/li").size());
        editor.sendKeys("\n");
        checkListButton.click();
    }

    @AfterAll
    static void closeup() {
        FirefoxDriverInitializer.getWebDriver().close();
//        ChromeDriverInitializer.getWebDriver().close();
    }

    static class WebdriverArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(firefoxHomePage)
            );
        }
    }

}
