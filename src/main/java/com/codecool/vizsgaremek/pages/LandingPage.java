package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Page{

    // LOCATORS
    // - Menu
    private static final By BUTTON_MENU = By.xpath("//button[@class='navbar-toggler collapsed']");
    // - Profile
    private static final By BUTTON_PROFILE = By.id("profile-btn");
    // - About
    private static final By BUTTON_ABOUT = By.xpath("//a[text()='About']");
    // - Logout
    private static final By BUTTON_LOGOUT = By.id("logout-link");
    // - Contact
    private static final By BUTTON_CONTACT = By.xpath("//*[@data-text='Get in touch']");
    // - Portfolio
    private static final By BUTTON_PORTFOLIO = By.xpath("//a[text()='Portfolio']");
    // - Blog
    private static final By BUTTON_BLOG = By.xpath("//*[@class='nav-item']//a[text()='Blog']");


    // Constructor
    public LandingPage(WebDriver driver) {
        super(Pages.LANDING_PAGE.getUrl(), driver);
    }


    // Verify successful login
    public boolean verifyLogin() {
        return findElementOnPage(BUTTON_LOGOUT).isDisplayed();
    }


    // Perform Logout
    public void performLogout() {
        findElementOnPage(BUTTON_LOGOUT).click();
    }


    // Navigate to AboutPage
    public void navigateToAboutPage() {
        findElementOnPage(BUTTON_ABOUT).click();
    }


    // Navigate to ContactPage
    public void navigateToContactPage() {
        findElementOnPage(BUTTON_CONTACT).click();
    }


    // Navigate to PortfolioPage
    public void navigateToPortfolioPage() {
        findElementOnPage(BUTTON_PORTFOLIO).click();
    }


    // Navigate to BlogPage
    public void navigateToBlogPage() {
        findElementOnPage(BUTTON_BLOG).click();
    }


    // Navigate to ProfilePage
    public void navigateToProfilePage() {
        findElementOnPage(BUTTON_PROFILE).click();
    }

}
