package com.codecool.vizsgaremek.pages;

import org.openqa.selenium.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

abstract class Page {

    private final WebDriver driver;
    private final String url;


    protected Page(String url, WebDriver driver) {
        this.url = url;
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    protected WebDriver getDriver() {
        return driver;
    }


    // Navigate to URL
    public final void navigateTo() {
        driver.navigate().to(url);
    }


    // FindElement on Page
    public final WebElement findElementOnPage(By locator) {
        return driver.findElement(locator);
    }


    // FindElements On Page
    public final List<WebElement> findElementsOnPage(By locator) {
        return driver.findElements(locator);
    }


    // Handle going over multiple page list and collect specific data
    public String[] goingOverMultiplePageListAndCollectData(By dataToGet, By buttonNextPage) {
        List<String> collectedData = new ArrayList<>();
        while (true) {
            List<WebElement> dataElements = findElementsOnPage(dataToGet);
            for (WebElement dataElement : dataElements) {
                collectedData.add(dataElement.getText());
            }
            try {
                findElementOnPage(buttonNextPage).click();
            } catch (ElementNotInteractableException e) {
                break;
            }
        }
        return collectedData.toArray(new String[0]);
    }


}
