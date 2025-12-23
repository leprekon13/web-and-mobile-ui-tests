package com.example.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaHomePage {
    private WebDriver driver;

    private By searchInput = By.name("search");
    private By searchButton = By.xpath("//button[contains(@class, 'search-form__button')]");
    private By mainPageLink = By.id("n-mainpage-description");

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://ru.wikipedia.org/");
    }

    public void enterSearchText(String text) {
        WebElement element = driver.findElement(searchInput);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void clickSearch() {
        try {
            WebElement button = driver.findElement(searchButton);
            if (button.isDisplayed()) {
                button.click();
            }
        } catch (Exception e) {
            driver.findElement(searchInput).sendKeys(Keys.ENTER);
        }
    }

    public boolean isMainPageLinkDisplayed() {
        return driver.findElement(mainPageLink).isDisplayed();
    }
}