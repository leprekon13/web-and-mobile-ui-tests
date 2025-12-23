package com.example.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaHomePage {
    private WebDriver driver;

    private By searchInput = By.id("searchInput");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By mainPageLink = By.id("n-mainpage-description");

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://ru.wikipedia.org/");
    }

    public void enterSearchText(String text) {
        driver.findElement(searchInput).sendKeys(text);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public boolean isMainPageLinkDisplayed() {
        return driver.findElement(mainPageLink).isDisplayed();
    }
}