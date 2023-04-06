package com.codecool.vizsgaremek.pages;
import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Feature("Login and logout")
public class LoginAndLogoutTest extends TestEnvironment {

    @Test
    @Description("Perform Login with already existed user")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Existed user login")
    void performLoginTest() {
        registrationAndLoginPage.acceptTermsNConditions();

        String username = "lovasia";
        String password = "kispal123";
        registrationAndLoginPage.performLogin(username, password);
        makeScreenshot("Successful login");
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    @Description("Perform login with empty password input field")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login without password")
    void performLoginWithoutGivenPassword() {
        registrationAndLoginPage.acceptTermsNConditions();

        String username = "lovasia";
        String password = "";
        registrationAndLoginPage.performLogin(username, password);
        makeScreenshot("Login declined: Username or Password is not correct!");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin());
    }


    @Test
    @Description("Perform login with misspelled username")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with misspelled username")
    void performLoginWithMisspelledUsername() {
        registrationAndLoginPage.acceptTermsNConditions();

        String username = "lovasiaa";
        String password = "kispal123";
        registrationAndLoginPage.performLogin(username, password);
        makeScreenshot("Login declined: Username or Password is not correct!");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin());
    }



    @Test
    @Description("Perform login with wrong password")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Login with wrong password")
    void performLoginWithWrongPassword() {
        registrationAndLoginPage.acceptTermsNConditions();

        String username = "lovasiaa";
        String password = "Kispal1234";
        registrationAndLoginPage.performLogin(username, password);
        makeScreenshot("Login declined: Username or Password is not correct!");
        Assertions.assertTrue(registrationAndLoginPage.verifyFailedLogin());
    }




    @Test
    @Description("Perform successful logout")
    @Story("Logout")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Perform logout")
    void performLogout() {
        registrationAndLoginPage.acceptTermsNConditions();

        String username = "lovasia";
        String password = "kispal123";
        registrationAndLoginPage.performLogin(username, password);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());

        landingPage.performLogout();
        makeScreenshot("Successful logout");
        Assertions.assertEquals(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }

}
