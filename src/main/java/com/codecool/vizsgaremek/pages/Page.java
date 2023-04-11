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


    // Navigate to URL
    public final void navigateTo() {
        driver.navigate().to(url);
    }


    // findElement on Page
    public final WebElement findElementOnPage(By locator) {
        return driver.findElement(locator);
    }


    // findElements On Page
    public final List<WebElement> findElementsOnPage(By locator) {
        return driver.findElements(locator);
    }


    // Handle alert - click on accept alert
    public void handleAlert() {
        driver.switchTo().alert().accept();
    }


    // Handle going over multiple page list and collect specific data
    public String[] goingOverMultiplePageListAndCollectData(By dataToGet, By buttonNextPage) {
        List<String> collectedData = new ArrayList<String>();
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


    // Listing data
    public String[] listingData(By locator) {
        List<WebElement> datas = findElementsOnPage(locator);
        String[] resultArray = new String[datas.size()];
        int count = 0;
        for(WebElement data : datas) {
            resultArray[count++] = data.getText();
        }
        return resultArray;
    }

}
