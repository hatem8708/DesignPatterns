package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {

    private By modalPop = By.id("MultiCityModelAlert");
    private By multiCityRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By search = By.name("ctl00$mainContent$btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String, String> bookingDetails) {
        makeStateReady(s-> selectOriginCity(bookingDetails.get("origin")));
        selectDestinationCity(bookingDetails.get("destination"));
        selectSecondOriginCity(bookingDetails.get("origin_s"));
        findElement(search).click();
    }



    public void selectOriginCity(String origin) {
        waitForElementToDisappear(modalPop);
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectSecondOriginCity(String origin_s){
        findElement(from2).click();
        findElement(By.xpath("(//a[@value='"+origin_s+"'])[3]")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        //common prerequisite code
        // Used for example for DataBase Connection
        findElement(multiCityRadio).click();
        findElement(modalPop).click();
        waitForElementToDisappear(modalPop);
        consumer.accept(this); /*Execute all methods of this current class*/
        //this refers to current class and .accept allows to execute any method of this current class
        // We can hardcode the method to execute: consumer.validateCalendar(this)

        System.out.println("done"); /*Tear down*/

        /*Use the Around Execute Pattern for database connection (or open a file to read it or write on it):
        1)Code to Connect to the database (Open the file as reader or writer or both)
        2) consumer.accept(this)
        3) tear down: Close the connection (Close the file)
         */
    }


}
