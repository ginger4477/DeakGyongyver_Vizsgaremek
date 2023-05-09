package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Epic("Roxo Webpage testing")
@Feature("Data modification test")
public class DataModificationTest extends TestEnvironment {


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
    @Description("Edit user account")
    @Story("The user is able to edit his account")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC15 - Edit user account")
    void editAccountTest() {
        landingPage.navigateToProfilePage();

        String name = "Jennifer";
        String bio = "Hey, this is me, Jennifer!";
        String phoneNumber = "123456789";
        profilePage.performEditAccount(name, bio, phoneNumber);

        makeScreenshot("Result of edit user account with data > name: " + name + ", bio: " + bio + ", phoneNumber: " + phoneNumber);
        Assertions.assertTrue(profilePage.verifyProfileEdit(), "Result of edit user account:");
    }


}



