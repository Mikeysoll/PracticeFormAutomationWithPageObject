package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.TestData;
import helpers.Attach;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import pages.PracticeFormPage;

public class TestBase {

    protected PracticeFormPage formPage;
    protected TestData testData;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @BeforeEach
    void setUp() {
        formPage = new PracticeFormPage();
        testData = new TestData();
        formPage.openPage();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterEach
    void addAtachments() {
        Attach.screenshotAs("Last screenshot");
    }
}