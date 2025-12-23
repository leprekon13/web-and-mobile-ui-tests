package com.example.mobile.tests;

import com.example.utils.BaseMobileTest;
import com.example.mobile.pages.WikipediaMobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaMobileTest extends BaseMobileTest {

    @Test(priority = 1)
    public void testSearchFunctionality() {
        WikipediaMobilePage mobilePage = new WikipediaMobilePage(driver);
        mobilePage.clickSearchContainer();
        mobilePage.enterSearchText("Appium");
        Assert.assertTrue(mobilePage.isSearchResultDisplayed());
    }

    @Test(priority = 2)
    public void testOpenArticle() {
        WikipediaMobilePage mobilePage = new WikipediaMobilePage(driver);
        mobilePage.clickSearchContainer();
        mobilePage.enterSearchText("Java");
        mobilePage.selectFirstSearchResult();
        String title = mobilePage.getArticleTitle();
        Assert.assertNotNull(title);
    }

    @Test(priority = 3)
    public void testScrollArticle() {
        WikipediaMobilePage mobilePage = new WikipediaMobilePage(driver);
        mobilePage.clickSearchContainer();
        mobilePage.enterSearchText("Selenium");
        mobilePage.selectFirstSearchResult();
        mobilePage.scrollToBottom();
    }
}