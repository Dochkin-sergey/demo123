package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpectationsAndTabNavigation {
    private WebDriver driver;

    public void expectation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.attributeContains(By.cssSelector("h2 > a[href]"), "href", "selenium"),
                ExpectedConditions.elementToBeClickable(By.cssSelector("h2 > a[href]"))));
                System.out.println("Ожидание до появления элементов");
    }

    public void switchTab(){
        ArrayList tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1).toString());
        System.out.println("Переключение вкладки");
    }

    public void URLCheck(){
        String URL = driver.getCurrentUrl();
        assertEquals(URL, "https://www.selenium.dev/");
        System.out.println("Проверка соответсвия URL при первом переходе");
    }

    public ExpectationsAndTabNavigation (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
