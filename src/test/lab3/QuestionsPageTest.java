package test.lab3;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
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
        chromeHomePage = new QuestionsPage(ChromeDriverInitializer.getWebDriver());
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

    @AfterAll
    static void closeup() {
        FirefoxDriverInitializer.getWebDriver().close();
        ChromeDriverInitializer.getWebDriver().close();
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
