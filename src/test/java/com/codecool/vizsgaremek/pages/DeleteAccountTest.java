package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeleteAccountTest extends TestEnvironment {

    @BeforeEach
    void performRegistrationAndLogin() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);
        registrationAndLoginPage.navigateToFormLogin();
        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    void performDeleteAccount() {
        landingPage.navigateToProfilePage();
        profilePage.performDeleteAccount();
        Assertions.assertEquals(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());

        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin());
    }

}
