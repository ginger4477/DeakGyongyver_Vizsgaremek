package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page{

    //Locators
    // - Inputs
    private static final By INPUT_NAME = By.id("name");
    private static final By INPUT_BIO = By.id("bio");
    private static final By INPUT_PHONE_NUMBER = By.id("phone-number");

    // - Buttons
    private static final By BUTTON_SAVE_PROFILE = By.xpath("//*[@onclick='editUser()']");
    private static final By BUTTON_DELETE_ACCOUNT = By.xpath("//*[@onclick='showRealDeleteAccBtn()']");
    private static final By BUTTON_CONFIRM_DELETE_ACCOUNT = By.id("delete-account-btn");

    // - Text verify
    private static final By TEXT_VERIFY_EDIT_ACCOUNT = By.id("edit-alert");


    // Constructor
    public ProfilePage(WebDriver driver) {
        super(Pages.PROFILE_PAGE.getUrl(), driver);
    }



}
