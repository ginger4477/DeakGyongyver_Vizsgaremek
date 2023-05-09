package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Epic("Roxo Webpage testing")
@Feature("Delete data test")
public class DeleteDataTest extends TestEnvironment {

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
    @Description("Delete user account")
    @Story("The user is able to delete his account")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC16 - Delete user account")
    void performDeleteAccount() {
        landingPage.navigateToProfilePage();

        makeScreenshot("Profile page before deletion process starting");

        profilePage.clickOnDeleteAccountButton();
        makeScreenshot("Profile page after step1 of deletion process: the confirmation delete button displayed");

        profilePage.clickOnConfirmDeleteButton();
        makeScreenshot("After step2 of deletion process: Arrive at the login page.");
        Assertions.assertEquals(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(), "Arrive at the correct url: ");

        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);
        makeScreenshot("Failed login after the account deletion process was successful");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin(), "Delete user account failed");
    }


}
