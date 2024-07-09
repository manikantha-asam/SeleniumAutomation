package com.expedia;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Expediaflight {

    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");//replace your chromedriver path

        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Navigate to ExpediaWebsite
        driver.get("https://www.expedia.com/");

        // Wait for the page to load and verify landing on the correct page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("Expedia"));

        // Print URL and Title of the Page
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        driver.manage().window().maximize();

        // Click on "Flights" tab
        WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[aria-controls='search_form_product_selector_flights']")));
        flightsTab.click();

        // Additional actions after clicking the new button, if any
        WebElement button1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Leaving from'][class='uitk-fake-input uitk-form-field-trigger']")));
        button1.click();

        // Wait for the origin city input field to be visible
        WebElement originCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.uitk-field-input.uitk-typeahead-input.uitk-typeahead-input-v2[placeholder='Leaving from']")));
        originCity.sendKeys("Kolkata");
        originCity.sendKeys(Keys.ENTER);

        WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Going to'][class='uitk-fake-input uitk-form-field-trigger']")));
        button2.click();

        // Enter destination city:Hyderabad
        WebElement destinationCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.uitk-field-input.uitk-typeahead-input.uitk-typeahead-input-v2[placeholder='Going to']")));
        destinationCity.sendKeys("Hyderabad");
        destinationCity.sendKeys(Keys.ENTER);

        WebElement button3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-stid='uitk-date-selector-input1-default']")));
        button3.click();

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='uitk-day-button uitk-day-selectable uitk-day-clickable'][div[@class='uitk-day-aria-label' and @aria-label='Thursday, August 22, 2024']]")));
        date.click();

        WebElement datedone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-stid='apply-date-selector' and text()='Done']")));
        datedone.click();

        WebElement button4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-stid='open-room-picker'][aria-label='Travelers, 1 traveler']")));
        button4.click();

        WebElement adult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='uitk-layout-flex uitk-layout-flex-item uitk-step-input-controls']/button[@type='button' and not(@disabled)]")));
        adult.click();

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#search_button.uitk-button.uitk-button-large.uitk-button-has-text.uitk-button-primary")));
        search.click();

        WebElement firstflight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-stid='FLIGHTS_DETAILS_AND_FARES-index-1-leg-0-fsr-FlightsActionButton' and .//span[@class='is-visually-hidden' and contains(text(), 'Select and show fare information for IndiGo flight')]]")));
        firstflight.click();

        // Close the browser
        driver.quit();
    }
}
