package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactFormTest extends TestEnvironment {

    private static final String FIRST_NAME = "Jennifer";
    private static final String LAST_NAME = "Green";
    private static final String EMAIL = "jenny_green@testmail.com";
    private static final String PROJECT_TYPE1 = "Graphics Design";
    private static final String PROJECT_TYPE2 = "Web Design";
    private static final String ABOUT_PROJECT1 = "i'd like to promote my project....";


    @BeforeEach
    void performRegistrationAndLogin() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);
        registrationAndLoginPage.navigateToFormLogin();
        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    void sendMessage() {
        landingPage.navigateToContactPage();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        contactPage.sendMessage(FIRST_NAME, LAST_NAME, EMAIL, PROJECT_TYPE1, ABOUT_PROJECT1);

        contactPage.handleAlert();
        makeScreenshot("verify success sent");

        String expected = "Message sent!";
        Assertions.assertEquals(expected, contactPage.successMessage());
    }




}
