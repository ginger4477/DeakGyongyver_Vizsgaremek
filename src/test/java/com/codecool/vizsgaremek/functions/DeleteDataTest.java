package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

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

        profilePage.performDeleteAccount();

        Assertions.assertEquals(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());

        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);

        makeScreenshot("Failed login after delete the account");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin(), "Delete user account failed");
    }


}
