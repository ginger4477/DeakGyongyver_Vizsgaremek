package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EditAccountTest extends TestEnvironment {

    private static final String NAME = "Jennifer";
    private static final String BIO = "Hey, this is me, Jennifer!";
    private static final String PHONE_NUMBER = "123456789";
    private static final String NAME2 = "Jenny";
    private static final String BIO2 = "Hey, it's still me";
    private static final String PHONE_NUMBER2 = "987654321";



    @BeforeEach
    void performRegistrationAndLogin() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);
        registrationAndLoginPage.navigateToFormLogin();
        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    void editAccountTest() {
        landingPage.navigateToProfilePage();

        profilePage.performEditAccount(NAME, BIO, PHONE_NUMBER);
        Assertions.assertTrue(profilePage.verifyProfileEdit());
    }



    @Test
    void editAccountMultipleTimesTest() {
        landingPage.navigateToProfilePage();

        profilePage.performEditAccount(NAME, BIO, PHONE_NUMBER);
        Assertions.assertTrue(profilePage.verifyProfileEdit());

        driver.navigate().refresh();

        profilePage.performEditAccount(NAME2, BIO2, PHONE_NUMBER2);
        Assertions.assertTrue(profilePage.verifyProfileEdit());
    }


}
