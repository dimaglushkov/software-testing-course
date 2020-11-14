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
import test.lab3.pages.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest {

    static HomePage firefoxHomePage;
    static HomePage chromeHomePage;

    @BeforeAll
    static void setup() {
        firefoxHomePage = new HomePage(FirefoxDriverInitializer.getWebDriver());
//        chromeHomePage = new HomePage(ChromeDriverInitializer.getWebDriver());
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void navigationTest(HomePage page) {
        String[] topNavigationBarUrls = {
                "https://www.answers.com/hot",
                "https://www.answers.com/best",
                "https://www.answers.com/trending"
        };

        List<String> topNavigationBarLinks = page.getTopNavigationBarLinks();

        for (int i = 0; i < topNavigationBarUrls.length; i++){
            page.open(topNavigationBarLinks.get(i));
            assertEquals(topNavigationBarUrls[i], page.getCurrentUrl());
        }
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void loginTest(HomePage page) {
        String username = "trshmil";
        String password = "3MUrSKK6EDbj4sN";
        assertTrue(page.login(username, password));
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void questionAuthorTest(HomePage page) {
        assertEquals("https://www.answers.com/page/wiki-users", page.getQuestionAuthor());
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void logoutTest(HomePage page) {
        assertTrue(page.logout());
    }

    @ParameterizedTest
    @ArgumentsSource(WebdriverArgumentsProvider.class)
    void footerTest(HomePage page) {
        List<String> expectedFooterLinks = new ArrayList<>();
        expectedFooterLinks.add("https://www.answers.com/page/about");
        expectedFooterLinks.add("https://blog.answers.com/");
        expectedFooterLinks.add("https://www.answers.com/page/cookie_policy");
        expectedFooterLinks.add("https://www.answers.com/page/contact-us");
        expectedFooterLinks.add("https://www.answers.com/page/copyright");
        expectedFooterLinks.add("https://www.answers.com/page/privacy#4");
        expectedFooterLinks.add("https://www.answers.com/page/terms-of-use");
        expectedFooterLinks.add("https://www.answers.com/page/disclaimer");
        expectedFooterLinks.add("https://multiplystl.typeform.com/to/M6Dy5g");
        expectedFooterLinks.add("https://www.answers.com/page/privacy");
        expectedFooterLinks.add("https://blog.answers.com/answers-community-guidelines/");

        List<String> actualFooterLinks = page.getFooterLinks();

        for (int i = 0; i < actualFooterLinks.size(); i++){
            assertEquals(expectedFooterLinks.get(i), actualFooterLinks.get(i));
        }

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
