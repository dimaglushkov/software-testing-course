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

import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest {

    static HomePage firefoxHomePage;
    static HomePage chromeHomePage;

    @BeforeAll
    static void setup() {
        firefoxHomePage = new HomePage(FirefoxDriverInitializer.getWebDriver());
        chromeHomePage = new HomePage(ChromeDriverInitializer.getWebDriver());
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
    void logoutTest(HomePage page) {
        assertTrue(page.logout());
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
                    Arguments.of(firefoxHomePage),
                    Arguments.of(chromeHomePage)
            );
        }
    }

}
