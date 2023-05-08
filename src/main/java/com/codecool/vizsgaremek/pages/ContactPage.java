package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


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


    // Sending message process: > Step1: Perform fill the contact form
    public void sendMessage(String firstName, String lastName, String email, String projectType, String aboutProject) {
        findElementOnPage(INPUT_FIRST_NAME).sendKeys(firstName);
        findElementOnPage(INPUT_LAST_NAME).sendKeys(lastName);
        findElementOnPage(INPUT_EMAIL).sendKeys(email);
        new Select(findElementOnPage(SELECT_PROJECT_TYPE)).selectByVisibleText(projectType);
        findElementOnPage(INPUT_ABOUT_PROJECT).sendKeys(aboutProject);
    }

    // Sending message process: > Step2: Click on send button for finish sending message process
    public void clickOnSendMessageButton() {
        findElementOnPage(BUTTON_SEND_MESSAGE).click();
    }


    // Verify success message sent
    public String successMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_VERIFY_MESSAGE_SENT));
        return findElementOnPage(TEXT_VERIFY_MESSAGE_SENT).getText();
    }

}
