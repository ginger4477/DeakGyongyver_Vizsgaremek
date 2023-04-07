package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;


@Epic("")
@Feature("Registration")
class RegistrationTest extends TestEnvironment {



    @Test
    @Description("Perform Registration for new user")
    @Story("A new user accept terms and conditions and complete a successful registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("New user registration")
    void performRegistrationTest() {
        registrationAndLoginPage.acceptTermsNConditions();
        String username = "hópihe";
        String password = "hahópihe";
        registrationAndLoginPage.performRegistration(username, password);
        makeScreenshot("User registered!");
        Assertions.assertTrue(registrationAndLoginPage.verifyRegistration());
    }



    @Test
    @Description("Perform Registration for new user and login with")
    @Story("A newly registered user perform successful login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("New user registration with login")
    void performRegistrationTest2() {
        registrationAndLoginPage.acceptTermsNConditions();
        String username = "phil";
        String password = "philipe44";
        registrationAndLoginPage.performRegistration(username, password);
        makeScreenshot("User registered!");
        Assertions.assertTrue(registrationAndLoginPage.verifyRegistration());

        registrationAndLoginPage.navigateToFormLogin();
        registrationAndLoginPage.performLogin(username, password);
        makeScreenshot("Successful login");
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }





}