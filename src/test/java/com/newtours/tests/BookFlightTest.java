package com.newtours.tests;

import com.newtours.pages.*;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setUpParameter(String noOfPassengers, String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmation(){
        RegistrationConfirmation registrationConfirmation = new RegistrationConfirmation(driver);
        registrationConfirmation.clickFlight();
    }

    @Test(dependsOnMethods = "registrationConfirmation")
    public void flightDetailsPage(){
        FlightDetails flightDetails = new FlightDetails(driver);
        flightDetails.selectPassengers(noOfPassengers);
        flightDetails.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightsPage();
        findFlightPage.goToFlightConfirmation();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmation flightConfirmation = new FlightConfirmation(driver);
        String actualPrice = flightConfirmation.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

}
