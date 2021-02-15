package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {

    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By search = By.name("ctl00$mainContent$btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String, String> bookingDetails) {
        makeStateReady(s->selectOriginCity(bookingDetails.get("origin")));
        selectDestinationCity(bookingDetails.get("destination"));
        findElement(cb).click();
        findElement(search).click();
    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<RoundTrip> consumer){
        findElement(rdo).click();
        consumer.accept(this);

    }

}
