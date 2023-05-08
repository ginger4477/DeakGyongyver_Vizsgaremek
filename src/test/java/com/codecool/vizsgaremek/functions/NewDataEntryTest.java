package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Epic("Roxo Webpage testing")
@Feature("New data entry test with contact form")
public class NewDataEntryTest extends TestEnvironment {

    @BeforeEach
    void performRegistrationAndLogin() {
        registrationAndLoginPage.navigateTo();
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);
        registrationAndLoginPage.navigateToFormLogin();
        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    @Description("Message sending throughout the contact form")
    @Story("The user is able to send message throughout the contact form")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC17 - Message sending test with valid inputs")
    void sendMessage() {
        landingPage.navigateToContactPage();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        String firstName = "Jennifer";
        String lastName = "Green";
        String email = "jenny_green@testmail.com";
        String projectType = "Graphics Design";
        String aboutProject = "i'd like to promote my project....";
        contactPage.sendMessage(firstName, lastName, email, projectType, aboutProject);

        makeScreenshot("Screenshot of the message which contains just valid inputs");
        contactPage.clickOnSendMessageButton();

        String expectedAlertMessage = "Message sent!";
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage, "The pop up alert box's message does not matching with the actual one which is display");

        driver.switchTo().alert().accept();

        String expectedMessage = "Message sent!";
        String actualMessage = contactPage.successMessage();
        makeScreenshot("Contact page after the message sending process was completed");
        Assertions.assertEquals(expectedMessage, actualMessage, "The expected message does not matching with the actual one which is display on the page after the sending process was completed");
    }



    @Test
    @Description("Message sending throughout the contact form with invalid email")
    @Story("The user is unable to send message throughout the contact form with invalid email")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC18 - Message sending test with invalid email")
    void sendMessageWithInvalidEmail() {
        landingPage.navigateToContactPage();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        String firstName = "Jennifer";
        String lastName = "Green";
        String email = "jenny_green@@@testmail.com";
        String projectType = "Web Design";
        String aboutProject = "i'd like to promote my project....";
        contactPage.sendMessage(firstName, lastName, email, projectType, aboutProject);

        makeScreenshot("Screenshot of the message which contains an invalid email input field > before the pop up window display");
        contactPage.clickOnSendMessageButton();

        String expectedAlertMessage = "Oops! There was a problem: Invalid email";
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage, "The pop up alert box's message does not matching with the actual one which is display");

        driver.switchTo().alert().accept();

        String expectedMessage = "Message sent!";
        String actualMessage = contactPage.successMessage();
        makeScreenshot("Contact page after the message sending process was completed");
        Assertions.assertEquals(expectedMessage, actualMessage, "The expected message does not matching with the actual one which is display on the page after the sending process was completed");
    }


}





