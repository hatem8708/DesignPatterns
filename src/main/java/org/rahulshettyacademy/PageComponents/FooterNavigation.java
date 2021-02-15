package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

public class FooterNavigation extends AbstractComponent {
    WebDriver driver;

    //method to handle flights footer locator only:

    By flights = By.cssSelector("[title ='Flights']");
    By links = By.cssSelector("a");

    public FooterNavigation(WebDriver driver, By sectionElement) {
        super(driver, sectionElement); // When you inherit parent class, you should invoke parent class constructor in child constructor
    }

    public String getFlightAttribute() {

      return findElement(flights).getAttribute("class");

    }

    public int getLinkCount(){
       return findElements(links).size();
    }

}
