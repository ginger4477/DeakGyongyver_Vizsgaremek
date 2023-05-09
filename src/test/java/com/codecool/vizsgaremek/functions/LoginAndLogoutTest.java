package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Epic("Roxo Webpage testing")
@Feature("Login and logout tests")
public class LoginAndLogoutTest extends TestEnvironment {

    @BeforeEach
    void acceptTermsAndConditions() {
        registrationAndLoginPage.navigateTo();
        registrationAndLoginPage.acceptTermsNConditions();
    }


    @Test
    @Description("Perform Login with already existed user")
    @Story("Already registered user perform successful login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC09 - Existed user login")
    void performLoginWithExistedUser() {
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);

        makeScreenshot("Result of login with existed user account");
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(landingPage.verifyLogin(), "Result of login with existed user:");
    }



    @Test
    @Description("Perform login with empty password input field")
    @Story("Already registered user can not login without password")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC10 - Login without password")
    void performLoginWithoutGivenPassword() {
        String emptyPasswordInput = "";
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, emptyPasswordInput);

        makeScreenshot("Result of login without password");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin(), "Result of login without password");
    }



    @Test
    @Description("Perform login with misspelled username")
    @Story("Already registered user can not login with misspelled username")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC11 - Login with misspelled username")
    void performLoginWithMisspelledUsername() {
        String misspelledUsername = "lovasiaa";
        registrationAndLoginPage.performLogin(misspelledUsername, BUILT_IN_PASSWORD);

        makeScreenshot("Result of login with misspelled username");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin(), "Result of login with misspelled username");
    }



    @Test
    @Description("Perform login with wrong password")
    @Story("Already registered user can not login with wrong password")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC12 - Login with wrong password")
    void performLoginWithWrongPassword() {
        String wrongPassword = "Kispal1234";
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, wrongPassword);

        makeScreenshot("Result of login with wrong password:");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin(), "Result of login with wrong password");
    }



    @Test
    @Description("Perform successful logout")
    @Story("A user perform successful logout")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC13 - Perform logout")
    void performLogout() {
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(landingPage.verifyLogin(), "Result of login");
        makeScreenshot("Result after login: arrive at the landing page");

        landingPage.performLogout();
        makeScreenshot("Result after logout: arrive at the login page");

        Assertions.assertEquals(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(registrationAndLoginPage.verifySuccessfulLogOut(), "As the result of successful logout, the login button displayed");
    }


}
