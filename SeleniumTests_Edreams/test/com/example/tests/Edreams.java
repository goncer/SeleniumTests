package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import javax.swing.text.Keymap;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Edreams {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.edreams.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEdreams() throws InterruptedException  {
    try
    {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.get(baseUrl);
    driver.findElement(By.xpath("//div[@id='flights-manager']/div[2]/div/ul/li")).click();
    driver.findElement(By.cssSelector("input.od-airportselector-input.airportselector_input")).clear();
    driver.findElement(By.cssSelector("input.od-airportselector-input.airportselector_input")).sendKeys("Mad");
          Thread.sleep(5000);
          //Thread.sleep(1000);
    driver.findElement(By.cssSelector("input.od-airportselector-input.airportselector_input")).sendKeys(Keys.RETURN);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("css=button.closeBtn.od-flightsManager-close-button")));
    driver.findElement(By.cssSelector("css=button.closeBtn.od-flightsManager-close-button")).click();
    
    driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div/span[2]")).click();
    driver.findElement(By.cssSelector("div.od-aside-button.inc")).click();
    driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[2]/div/div[2]/div/div[3]")).click();
    driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[3]/div/div[2]/div/div[3]")).click();
    driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[3]/div/div[2]/div/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='pax-selector']/div/div/div[2]/div[2]/div/div[2]/div/div[2]")).click();
    assertEquals("2 adults", driver.findElement(By.id("passengers_selector")).getText());
    } catch (Exception ex)
    {
        System.err.println("Error in !" + ex.getMessage());
        throw ex;
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
