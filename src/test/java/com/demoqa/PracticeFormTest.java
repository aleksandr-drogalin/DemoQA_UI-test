package com.demoqa;

import com.demoqa.model.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;


public class PracticeFormTest
{
    private static WebDriver driver;
    private final String CHROME_BROWSER = "chrome";
    private final String FIREFOX_BROWSER = "firefox";

    @BeforeEach
    public void setUp() {
        driver = Browser.selectBrowser(CHROME_BROWSER);
        driver.get("https://demoqa.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("проверка нажатия кнопки Forms")
    public void checkClickOnButtonForms() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnButtonForms();
    }
}
