package com.codecool.vizsgaremek.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


abstract class Page {

    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final String url;


    protected Page(String url, WebDriver driver) {
        this.url = url;
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }


    // Navigate to URL
    public final void navigateTo() {
        driver.navigate().to(url);
    }


    // findElement on Page
    public final WebElement findElementOnPage(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }




}
