package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Page{

    // LOCATORS
    // - Logout
    private static final By BUTTON_LOGOUT = By.xpath("//*[@onclick='logout()']");

    public LandingPage(WebDriver driver) {
        super(Pages.LANDING_PAGE.getUrl(), driver);
    }

    // Perform Logout
    public void performLogout() {
        findElementOnPage(BUTTON_LOGOUT).click();
    }



}
