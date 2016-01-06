/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edreams.PageObject;

import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.Debug;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EdreamsSearchPage {

    private final WebDriver driver;
    private final String PAGE_URL = "http://www.edreams.com/";
    
    @FindBy(css="input.od-airportselector-input.airportselector_input")
    private WebElement inputFrom;
    //css=input.od-airportselector-input.airportselector_input
    //css=input.od-airportselector-input.airportselector_input
    
    private static final By FromAirportTxtB = By.cssSelector("input.od-airportselector-input.airportselector_input");
    private static final By PassagerSelectCMB = By.cssSelector("div.paxselector_label.od-moreoptions-label");
    private static final By AddChildBtn = By.xpath("div[@id='pax-selector']/div/div/div[2]/div[2]/div/div[2]/div/div[3]");
    private static final By ManageFlightBtn = By.xpath("//div[@id='flights-manager']/div[2]/div/ul/li");
    
   public EdreamsSearchPage(WebDriver driver) {
      this.driver = driver;
   }
 
   public EdreamsSearchPage open() {
      driver.get(PAGE_URL);
      try {
            Thread.sleep(5000); //wait a bit to the modal! and then press return.
        } catch (InterruptedException ex) {
            Logger.getLogger(EdreamsSearchPage.class.getName()).log(Level.SEVERE, null, ex);
        }
      return this;
   }

    public void search(String FromAirport, String toAirport, int numAdults, int numchilds) {
        
        System.out.println("Select flight");
        driver.findElement(ManageFlightBtn).click();
        System.out.println("clean From airport");
        
        //inputFrom.clear();
        driver.findElement(FromAirportTxtB).clear();
        
        if(!FromAirport.isEmpty()){
            System.err.println("add airport filter");
            driver.findElement(FromAirportTxtB).sendKeys("Mad");
            try {
                Thread.sleep(5000); //wait a bit to the modal! and then press return.
            } catch (InterruptedException ex) {
                Logger.getLogger(EdreamsSearchPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            driver.findElement(FromAirportTxtB).sendKeys(Keys.RETURN);
            driver.findElement(FromAirportTxtB).sendKeys(Keys.TAB);
        }
        System.out.println("clean From airport");
        //while numAdults.. Click
        
        //while numChlds.. Click
        driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div/span[2]")).click();
        driver.findElement(By.cssSelector("div.od-aside-button.inc")).click();
        driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[2]/div/div[2]/div/div[3]")).click();
        driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[3]/div/div[2]/div/div[3]")).click();
        driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[3]/div/div[2]/div/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[2]/div/div[2]/div/div[2]")).click();
    }
 
}

