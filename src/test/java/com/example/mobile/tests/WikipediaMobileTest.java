package com.example.mobile.tests;

import com.example.utils.BaseMobileTest;
import com.example.mobile.pages.WikipediaMobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaMobileTest extends BaseMobileTest {

    @Test
    public void testSearchFunctionality() {
        WikipediaMobilePage mobilePage = new WikipediaMobilePage(driver);

        mobilePage.clickSearchContainer();
        mobilePage.enterSearchText("Appium");

        Assert.assertTrue(mobilePage.isSearchResultDisplayed());
    }
}