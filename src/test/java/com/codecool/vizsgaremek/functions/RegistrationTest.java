package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.*;
import java.io.FileReader;


@Epic("Roxo Webpage testing")
@Feature("Registration tests")
class RegistrationTest extends TestEnvironment {

    @BeforeEach
    void acceptTermsAndConditions() {
        registrationAndLoginPage.navigateTo();
        registrationAndLoginPage.acceptTermsNConditions();
    }


    @Test
    @Description("Perform Registration for new user")
    @Story("A new user accept terms and conditions and complete a successful registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC04 - New user registration")
    void performRegistrationTest() {
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);

        makeScreenshot("Result of new user registration: User registered!");
        Assertions.assertTrue(registrationAndLoginPage.verifyRegistration(), "Result of registration for new user:");
    }



    @Test
    @Description("Perform Registration for new user and login with")
    @Story("A newly registered user perform successful login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC05 - New user registration with login")
    void performRegistrationTest2() {
        registrationAndLoginPage.performRegistration(TEST_USERNAME, TEST_PASSWORD, TEST_EMAIL, TEST_DESCRIPTION);
        makeScreenshot("Result of new user registration: User registered!");
        Assertions.assertTrue(registrationAndLoginPage.verifyRegistration(), "Result of registration");

        registrationAndLoginPage.navigateToFormLogin();
        registrationAndLoginPage.performLogin(TEST_USERNAME, TEST_PASSWORD);

        makeScreenshot("Result of login after a newly created registration:");
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
        Assertions.assertTrue(landingPage.verifyLogin(), "Result of login after a newly created registration:");
    }



    @Test
    @Description("Perform Registration without password given")
    @Story("A user is not able to register an account with empty password input field")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC06 - New user registration without password given")
    void registrationWithoutPassword() {
        String password = "";
        registrationAndLoginPage.performRegistration(TEST_USERNAME, password, TEST_EMAIL, TEST_DESCRIPTION);

        makeScreenshot("Result of new user registration with empty password filed");
        Assertions.assertFalse(registrationAndLoginPage.verifyRegistration(), "Result of registration with empty password input field:");
    }



    @Test
    @Description("Perform Registration with empty input fields")
    @Story("A user is not able to register an account with empty input fields")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC07 - New user registration without empty input fields")
    void registrationWithEmptyInputFields() {
        String userName = "";
        String password = "";
        String email = "";
        String description = "";
        registrationAndLoginPage.performRegistration(userName, password, email, description);

        makeScreenshot("Result of new user registration if user let all input fields are empty");
        Assertions.assertFalse(registrationAndLoginPage.verifyRegistration(), "Result of new user registration if user let all input fields are empty:");
    }



    @Test
    @Description("Perform multiple registration from Json file")
    @Story("Repeated and sequential data entries: multiple registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC08 - Multiple registration from Json file")
    void multipleRegistrationFromJsonFile() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/users.json"));
        JSONArray jsonArray = (JSONArray) obj;

        // Going through all the options that are in the users.json file
        for (Object o : jsonArray) {
            JSONObject user = (JSONObject) o;
            String username = (String) user.get("username");
            String password = (String) user.get("password");
            String email = (String) user.get("email");
            String description = (String) user.get("description");

            // Perform the registration test with all username-password-email-description combinations
            registrationAndLoginPage.performRegistration(username, password, email, description);
            Assertions.assertTrue(registrationAndLoginPage.verifyRegistration(), "Result of multiple registration:");

            String screenshotName = "Result of multiple new registration from users.json file for user: " + username;
            makeScreenshot(screenshotName);

            driver.navigate().refresh();
        }
    }


}