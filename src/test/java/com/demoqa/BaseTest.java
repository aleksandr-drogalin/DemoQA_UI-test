package com.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    private final String CHROME_BROWSER = "chrome";
    private final String FIREFOX_BROWSER = "firefox";

    @BeforeEach
    protected void setUp() {
        driver = Browser.selectBrowser(CHROME_BROWSER);
        driver.get("https://demoqa.com/");
    }

    @AfterEach
    protected void setEnd() {
        driver.quit();
    }
}
