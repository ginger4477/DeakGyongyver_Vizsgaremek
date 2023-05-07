package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


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
    @DisplayName("TC17 - Message sending test")
    void sendMessage() {
        landingPage.navigateToContactPage();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        String firstName = "Jennifer";
        String lastName = "Green";
        String email = "jenny_green@testmail.com";
        String projectType1 = "Graphics Design";
        String aboutProject = "i'd like to promote my project....";
        contactPage.sendMessage(firstName, lastName, email, projectType1, aboutProject);

        String expectedAlertMessage = "Message sent!";
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage, "Wrong alert box message");

        driver.switchTo().alert().accept();

        String expectedMessage = "Message sent!";
        String actualMessage = contactPage.successMessage();
        makeScreenshot("Verify success sent message on the page");
        Assertions.assertEquals(expectedMessage, actualMessage, "Wrong success message on the page");
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

        String expectedAlertMessage = "Oops! There was a problem: Invalid email";
        String actualAlertMessage = driver.switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertMessage, actualAlertMessage, "Wrong alert box message");

        driver.switchTo().alert().accept();

        String expectedMessage = "Message sent!";
        String actualMessage = contactPage.successMessage();
        makeScreenshot("Verify success sent message on the page");
        Assertions.assertEquals(expectedMessage, actualMessage, "Wrong success message on the page");
    }



}





