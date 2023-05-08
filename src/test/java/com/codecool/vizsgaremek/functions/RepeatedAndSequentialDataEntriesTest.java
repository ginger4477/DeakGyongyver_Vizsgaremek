package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import java.io.FileReader;
import java.io.IOException;

@Epic("Roxo Webpage testing")
@Feature("Repeated And Sequential Data Entries Test")
public class RepeatedAndSequentialDataEntriesTest extends TestEnvironment {

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
    @Description("Edit user account multiple times")
    @Story("The user is able to edit his account multiple times")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC27 - Multiple edit user account")
    void editAccountMultipleTimesTest() throws IOException, ParseException {
        landingPage.navigateToProfilePage();
        Assertions.assertEquals(Pages.PROFILE_PAGE.getUrl(), driver.getCurrentUrl());

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/editUser.json"));
        JSONArray jsonArray = (JSONArray) obj;

        // Going through all the possibility in the editUser.json
        for (Object o : jsonArray) {
            JSONObject user = (JSONObject) o;
            String name = (String) user.get("name");
            String bio = (String) user.get("bio");
            String phoneNumber = (String) user.get("phoneNumber");

            // Perform edit profile with all the possibility in the json file
            profilePage.performEditAccount(name, bio, phoneNumber);
            Assertions.assertTrue(profilePage.verifyProfileEdit(), "The displayed message on the page after the edit process is matching with the expected one");

            String screenshotName = "Edit user profile with test datas from editUser.json: > " + name + ", " + bio + ", " + phoneNumber;
            makeScreenshot(screenshotName);

            driver.navigate().refresh();
        }
    }



    @Test
    @Description("Message sending throughout the contact form multiple times")
    @Story("The user able to send message throughout the contact form multiple times")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC28 - Message sending test from Json file multiple times")
    void sendMessageMultipleTimes() throws IOException, ParseException {
        landingPage.navigateToContactPage();
        Assertions.assertEquals(Pages.CONTACT_PAGE.getUrl(), driver.getCurrentUrl());

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/contactForm.json"));
        JSONArray jsonArray = (JSONArray) obj;

        SoftAssertions softAssert = new SoftAssertions();

        // Going through all the possibility in the contactForm.json
        for (Object o : jsonArray) {
            JSONObject user = (JSONObject) o;
            String firstName = (String) user.get("firstName");
            String lastName = (String) user.get("lastName");
            String email = (String) user.get("email");
            String projectType = (String) user.get("projectType");
            String aboutProject = (String) user.get("aboutProject");

            // Perform sendMessage with all the possibility in the json file
            contactPage.sendMessage(firstName, lastName, email, projectType, aboutProject);

            makeScreenshot("Screenshot of the message inputs before sending it with test data from contactForm.json: > Sent by: " + firstName + " " + lastName);
            contactPage.clickOnSendMessageButton();

            String expectedAlertMessage = "Message sent!";
            String actualAlertMessage = driver.switchTo().alert().getText();
            Assertions.assertEquals(expectedAlertMessage, actualAlertMessage, "The pop up alert box's message does not matching with the actual one which is display");

            driver.switchTo().alert().accept();

            String expected = "Message sent!";
            softAssert.assertThat(contactPage.successMessage())
                    .as("Wrong success message on the page, message data from contactForm.json, sent by: " + firstName + " " + lastName)
                    .isEqualTo(expected);

            String screenshotName = "Screenshot after send message process was completed with test data from contactForm.json: > Sent by: " + firstName + " " + lastName;
            makeScreenshot(screenshotName);
            driver.navigate().refresh();
        }
        softAssert.assertAll();
    }


}
