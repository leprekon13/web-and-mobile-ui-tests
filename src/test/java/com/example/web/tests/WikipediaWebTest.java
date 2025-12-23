package com.example.web.tests;

import com.example.utils.BaseWebTest;
import com.example.web.pages.WikipediaHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaWebTest extends BaseWebTest {

    @Test
    public void testMainPageDisplay() {
        WikipediaHomePage homePage = new WikipediaHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isMainPageLinkDisplayed());
    }

    @Test
    public void testSearchFunctionality() {
        WikipediaHomePage homePage = new WikipediaHomePage(driver);
        homePage.open();
        homePage.enterSearchText("Selenium");
        homePage.clickSearch();
        Assert.assertTrue(driver.getTitle().contains("Selenium"));
    }

    @Test
    public void testNavigationToCommunityPortal() {
        WikipediaHomePage homePage = new WikipediaHomePage(driver);
        homePage.open();
        homePage.enterSearchText("Википедия:Портал сообщества");
        homePage.clickSearch();
        Assert.assertTrue(driver.getCurrentUrl().contains("Портал_сообщества"));
    }

    @Test
    public void testLanguageLinkPresence() {
        WikipediaHomePage homePage = new WikipediaHomePage(driver);
        homePage.open();
        Assert.assertTrue(driver.getPageSource().contains("lang"));
    }
}