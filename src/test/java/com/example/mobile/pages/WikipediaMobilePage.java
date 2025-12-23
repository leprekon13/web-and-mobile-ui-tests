package com.example.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikipediaMobilePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    private By searchContainer = AppiumBy.xpath("//*[contains(@resource-id, 'search_container')]");
    private By searchInput = AppiumBy.xpath("//*[contains(@resource-id, 'search_src_text')]");
    private By searchResult = AppiumBy.xpath("//*[contains(@resource-id, 'page_list_item_title')]");
    private By skipButton = AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button");
    private By articleTitle = AppiumBy.xpath("//android.view.View[@content-desc]");
    private By closeButton = AppiumBy.id("org.wikipedia.alpha:id/closeButton");

    public WikipediaMobilePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private void dismissPopups() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        try {
            List<WebElement> onboardingSkip = driver.findElements(skipButton);
            if (!onboardingSkip.isEmpty()) onboardingSkip.get(0).click();

            List<WebElement> gameDialogClose = driver.findElements(closeButton);
            if (!gameDialogClose.isEmpty()) gameDialogClose.get(0).click();
        } catch (Exception e) {
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void clickSearchContainer() {
        dismissPopups();
        wait.until(ExpectedConditions.elementToBeClickable(searchContainer)).click();
    }

    public void enterSearchText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(text);
    }

    public void selectFirstSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(searchResult)).click();
    }

    public boolean isSearchResultDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getArticleTitle() {
        dismissPopups();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(articleTitle)).getAttribute("content-desc");
    }

    public void scrollToBottom() {
        dismissPopups();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
    }
}