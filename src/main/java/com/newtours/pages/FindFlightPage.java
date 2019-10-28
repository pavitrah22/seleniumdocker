package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement firstContinue;

    @FindBy(name =  "buyFlights")
    private WebElement secondContinue;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void submitFindFlightsPage(){
       this.wait.until(ExpectedConditions.elementToBeClickable(firstContinue));
        this.firstContinue.click();
    }

    public void goToFlightConfirmation(){
        this.wait.until(ExpectedConditions.elementToBeClickable(secondContinue));
        this.secondContinue.click();
    }
}
