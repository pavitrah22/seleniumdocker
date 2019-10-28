package com.searchModule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchTxt;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid__dur")
    private List<WebElement> allVideos;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void  goTo() throws InterruptedException {
        this.driver.get("https://duckduckgo.com");
       // this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        sleep(1000);
    }

    public void doSearch(String keyword) throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        sleep(1000);
        this.searchTxt.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVedios() throws InterruptedException {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
        sleep(1000);
    }

    public int getReslt(){
        By by = By.className("tile--vid__dur");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }
}
