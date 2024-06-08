package org.example.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsPage {
    @FindBy(css = "#sb_form_q")
    private WebElement searchField;
    @FindBy(css = "h2 > a[href]")
    private List<WebElement> issuance;

    public void clickElement( int num) {
        issuance.get(num).click();
        System.out.println("Нажатие на результат под номером " + num);
    }

    public String getTextSearchField(){
        String val = searchField.getAttribute("value");
        System.out.println("В строке поиска текст: " + val);
        return (val);
    }

    public ResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}



