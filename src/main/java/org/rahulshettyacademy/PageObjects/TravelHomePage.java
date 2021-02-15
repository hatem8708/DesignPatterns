package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvailability;
import org.rahulshettyacademy.AbstractComponents.StrategyFactory;
import org.rahulshettyacademy.PageComponents.FooterNavigation;
import org.rahulshettyacademy.PageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By headerNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvailability searchFlightAvailability;


    public TravelHomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void goTo(){

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar(){

        return new NavigationBar(driver, headerNavSectionElement);
    }

    public FooterNavigation getFooterNavigation(){

        return new FooterNavigation(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType){

        StrategyFactory strategyFactory = new StrategyFactory(driver);
        searchFlightAvailability = strategyFactory.createStrategy(strategyType);
        this.searchFlightAvailability = searchFlightAvailability;

    }

    public void checkAvailability(HashMap<String, String> bookingDetails) {

        searchFlightAvailability.checkAvailability(bookingDetails);
    }

    public String getTitle(){

        System.out.println("I'm deployed in JFROG now");
        return driver.getTitle();
    }
}
