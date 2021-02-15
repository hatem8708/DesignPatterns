package org.rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageComponents.MultiTrip;
import org.rahulshettyacademy.PageComponents.RoundTrip;

public class StrategyFactory {

    WebDriver driver;
    By SectionElement = By.id("flightSearchContainer");

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvailability createStrategy(String strategyType){
        if(strategyType.equalsIgnoreCase("multitrip")){

            return new MultiTrip(driver, SectionElement);

        }
        if(strategyType.equalsIgnoreCase("roundtrip")){

            return new RoundTrip(driver, SectionElement);
        }
        return null;
    }
}
