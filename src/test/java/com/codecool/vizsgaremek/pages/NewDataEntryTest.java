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

@Feature("New data entry test with contact form")
public class NewDataEntryTest extends TestEnvironment {

    private static final String FIRST_NAME = "Jennifer";
    private static final String LAST_NAME = "Green";
    private static final String EMAIL = "jenny_green@testmail.com";
    private static final String PROJECT_TYPE1 = "Graphics Design";
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
    @Description("Message sending throughout the contact form")
    @Story("The user is able to send message throughout the contact form")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Message sending test")
    void sendMessage() {
        landingPage.navigateToContactPage();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        contactPage.sendMessage(FIRST_NAME, LAST_NAME, EMAIL, PROJECT_TYPE1, ABOUT_PROJECT1);

        contactPage.handleAlert();
        makeScreenshot("verify success sent");

        String expected = "Message sent!";
        String errorMessage = String.format("Message sent by: " + FIRST_NAME + " " + LAST_NAME);
        Assertions.assertEquals(expected, contactPage.successMessage(), errorMessage);
    }



    @Test
    @Description("Send random message throughout the contact form from json file")
    @Story("We are able to send random message throughout the contact form from json")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Random message sending test from Json file")
    void sendRandomMessage() throws IOException, ParseException {
        landingPage.navigateToContactPage();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("contactForm.json"));
        JSONArray jsonArray = (JSONArray) obj;

        // Choose a random user data and message combination from the contactForm.json
        JSONObject user = (JSONObject) jsonArray.get(new Random().nextInt(jsonArray.size()));
        String firstName = (String) user.get("firstName");
        String lastName = (String) user.get("lastName");
        String email = (String) user.get("email");
        String projectType = (String) user.get("projectType");
        String aboutProject = (String) user.get("aboutProject");

        // Perform send message with this random choosen datas
        contactPage.sendMessage(firstName, lastName, email, projectType, aboutProject);
        contactPage.handleAlert();

        makeScreenshot("verify success sent");
        String expected = "Message sent!";
        String errorMessage = String.format("Message sent by: " + firstName + " " + lastName);
        Assertions.assertEquals(expected, contactPage.successMessage(), errorMessage);
    }



}





