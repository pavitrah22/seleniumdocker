package com.searchModule.tests;

import com.searchModule.pages.SearchPage;
import com.test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class searchTests extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchPage(String keyword) throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVedios();
        int size = searchPage.getReslt();
        Assert.assertTrue(size > 0);
    }
}

