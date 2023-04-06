package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationAndLoginPage extends Page{

    // LOCATORS
    // - Terms and Conditions
    private static final By BUTTON_ACCEPT_CONDITIONS = By.id("terms-and-conditions-button");
    private static final By TNC_POPUP = By.className("popup");

    // - Registration
    private static final By FORM_REGISTER = By.xpath("//*[@id='login']/*[@id='register-form-button']");
    private static final By INPUT_REGISTER_USERNAME = By.id("register-username");
    private static final By INPUT_REGISTER_PASSWORD = By.id("register-password");
    //private static final By INPUT_REGISTER_EMAIL =  By.id("register-email");
    //private static final By INPUT_REGISTER_DESCRIPTION = By.id("register-description");
    private static final By BUTTON_REGISTER = By.xpath("//*[@onclick='registerUser()']");
    private static final By TEXT_VERIFY_REGISTER = By.id("register-alert");

    // - Login
    private static final By FORM_lOGIN = By.xpath("//*[@id='register']/*[@id='login-form-button']");
    private static final By INPUT_LOGIN_USERNAME = By.id("email");
    private static final By INPUT_LOGIN_PASSWORD = By.id("password");
    private static final By BUTTON_LOGIN = By.xpath("//*[@onclick='myFunction()']");
    private static final By TEXT_VERIFY_FAILED_LOGIN = By.id("alert");




    public RegistrationAndLoginPage(WebDriver driver) {
        super(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver);
    }


    // Accept Term and Conditions
    public void acceptTermsNConditions() {
        findElementOnPage(BUTTON_ACCEPT_CONDITIONS).click();
    }



    // Verify Term and Conditions Window isDisplayed
    public boolean isTnCPopupDisplayed() {
        return findElementOnPage(TNC_POPUP).isDisplayed();
    }




    // Perform Registration
    public void performRegistration(String username, String password) {
        findElementOnPage(FORM_REGISTER).click();
        findElementOnPage(INPUT_REGISTER_USERNAME).sendKeys(username);
        findElementOnPage(INPUT_REGISTER_PASSWORD).sendKeys(password);
        findElementOnPage(BUTTON_REGISTER).click();
    }


    // Verify registration
    public boolean verifyRegistration() {
        return findElementOnPage(TEXT_VERIFY_REGISTER).isDisplayed();
    }


    // Perform Login
    public void performLogin(String username, String password) {
        findElementOnPage(INPUT_LOGIN_USERNAME).sendKeys(username);
        findElementOnPage(INPUT_LOGIN_PASSWORD).sendKeys(password);
        findElementOnPage(BUTTON_LOGIN).click();
    }


    public boolean verifyFailedLogin() {
        return findElementOnPage(TEXT_VERIFY_FAILED_LOGIN).isDisplayed();
    }



    public void navigateToFormLogin() {
        findElementOnPage(FORM_lOGIN).click();
    }




}
