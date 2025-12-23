package com.example.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaMobilePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By searchContainer = AppiumBy.xpath("//*[contains(@resource-id, 'search_container')]");
    private By searchInput = AppiumBy.xpath("//*[contains(@resource-id, 'search_src_text')]");
    private By searchResult = AppiumBy.xpath("//*[contains(@resource-id, 'page_list_item_title')]");
    private By skipButton = AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button");

    public WikipediaMobilePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickSearchContainer() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(skipButton)).click();
        } catch (Exception e) {
        }
        wait.until(ExpectedConditions.elementToBeClickable(searchContainer)).click();
    }

    public void enterSearchText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(text);
    }

    public boolean isSearchResultDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult)).isDisplayed();
    }
}