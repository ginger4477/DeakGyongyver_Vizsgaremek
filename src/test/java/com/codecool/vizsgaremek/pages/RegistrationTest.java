package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.*;
import java.io.FileReader;



@Epic("")
@Feature("Registration tests")
class RegistrationTest extends TestEnvironment {

    @BeforeEach
    void acceptTermsAndConditions() {
        registrationAndLoginPage.acceptTermsNConditions();
    }

    @Test
    @Description("Perform Registration for new user")
    @Story("A new user accept terms and conditions and complete a successful registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("New user registration")
    void performRegistrationTest() {
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);

        makeScreenshot("User registered!");
        Assertions.assertTrue(registrationAndLoginPage.verifyRegistration());
    }



    @Test
    @Description("Perform Registration for new user and login with")
    @Story("A newly registered user perform successful login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("New user registration with login")
    void performRegistrationTest2() {
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);
        makeScreenshot("User registered!");
        Assertions.assertTrue(registrationAndLoginPage.verifyRegistration());

        registrationAndLoginPage.navigateToFormLogin();
        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);

        makeScreenshot("Successful login");
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(landingPage.verifyLogin());
    }




    @Test
    @Description("Perform multiple registration from Json file")
    @Story("Repeated and sequential data entries: multiple registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Multiple registration from Json file")
    public void multipleRegistrationFromJsonFile() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("users.json"));
        JSONArray jsonArray = (JSONArray) obj;

        // Going through all the options that are in the users.json file
        for (Object o : jsonArray) {
            JSONObject user = (JSONObject) o;
            String username = (String) user.get("username");
            String password = (String) user.get("password");
            String email = (String) user.get("email");
            String description = (String) user.get("description");

            // Perform the registration test with all username-password-email-description combinations
            String screenshotName = "registration_" + username;
            registrationAndLoginPage.performRegistration(username, password, email, description);
            Assertions.assertTrue(registrationAndLoginPage.verifyRegistration());
            makeScreenshot(screenshotName);
            driver.navigate().refresh();
        }
    }


}