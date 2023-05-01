package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

@Feature("Data modification test")
public class DataModificationTest extends TestEnvironment {

    private static final String NAME = "Jennifer";
    private static final String BIO = "Hey, this is me, Jennifer!";
    private static final String PHONE_NUMBER = "123456789";



    @BeforeEach
    void performRegistrationAndLogin() {
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
    @DisplayName("Edit user account")
    void editAccountTest() {
        landingPage.navigateToProfilePage();

        profilePage.performEditAccount(NAME, BIO, PHONE_NUMBER);

        makeScreenshot("Account edited");
        Assertions.assertTrue(profilePage.verifyProfileEdit());
    }



    @Test
    @Description("Edit user account with random data from json file")
    @Story("We are able to edit user account random from json file")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Random account edit from json file")
    void editAccountWithRandomData() throws IOException, ParseException {
        landingPage.navigateToProfilePage();
        Assertions.assertEquals(Pages.PROFILE_PAGE.getUrl(), driver.getCurrentUrl());

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("editUser.json"));
        JSONArray jsonArray = (JSONArray) obj;

        // Randomly select an edit user option that is in the editUser.json file
        JSONObject user = (JSONObject) jsonArray.get(new Random().nextInt(jsonArray.size()));
        String name = (String) user.get("name");
        String bio = (String) user.get("bio");
        String phoneNumber = (String) user.get("phoneNumber");

        // Perform the edit profile using a randomly chosen combination name-bio-phoneNumber
        profilePage.performEditAccount(name, bio, phoneNumber);
        Assertions.assertTrue(profilePage.verifyProfileEdit());

        String screenshotName = "edit_profile_to_" + name;
        makeScreenshot(screenshotName);

        }


}



