package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends Page{

    // LOCATORS
    // - Inputs
    private static final By INPUT_FIRST_NAME = By.id("first-name");
    private static final By INPUT_LAST_NAME = By.id("last-name");
    private static final By INPUT_EMAIL = By.id("email");
    private static final By INPUT_ABOUT_PROJECT = By.id("aboutProject");

    // - Select field
    private static final By SELECT_PROJECT_TYPE = By.id("projectType");

    // - Button
    private static final By BUTTON_SEND_MESSAGE = By.id("contact-form-button");

    // - Text verify
    private static final By TEXT_VERIFY_MESSAGE_SENT = By.id("contact-form-status");


    // - Constructor
    public ContactPage(WebDriver driver) {
        super(Pages.CONTACT_PAGE.getUrl(), driver);
    }




}
