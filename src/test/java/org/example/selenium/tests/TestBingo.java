package org.example.selenium.tests;

import org.example.selenium.pages.ExpectationsAndTabNavigation;
import org.example.selenium.pages.MainPage;
import org.example.selenium.pages.ResultsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBingo {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchFieldTest() {
        String input = "Selenium";

        MainPage mp = new MainPage(driver);
        mp.sendText(input);

        ResultsPage rp = new ResultsPage(driver);
        assertEquals(input, rp.getTextSearchField(), "Текст не совпал");
    }

    @DisplayName("URL")
    @Test
    public void searchResultTest() {
        String input = "Selenium";
        MainPage mp = new MainPage(driver);
        ResultsPage rp = new ResultsPage(driver);
        ExpectationsAndTabNavigation ost = new ExpectationsAndTabNavigation(driver);

        mp.sendText(input);
        ost.expectation();
        rp.clickElement(0);
        ost.switchTab();
        ost.URLCheck();
    }
}