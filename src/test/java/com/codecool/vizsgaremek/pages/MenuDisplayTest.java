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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Feature("Menu display test")
public class MenuDisplayTest extends TestEnvironment {

    @BeforeEach
    void performLogin() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    @Description("The correct menu is displayed")
    @Story("The user is able to see the correct menu")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Menu display validation")
    public void testMenu() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object expectedObj = parser.parse(new FileReader("expectedMenu.json"));
        JSONArray expectedArray = (JSONArray) expectedObj;
        Map<String, List<String>> expectedResult = new HashMap<>();

        for (Object item : expectedArray) {
            JSONObject menuItem = (JSONObject) item;
            String key = (String) menuItem.get("name");
            String value = (String) menuItem.get("url");
            List<String> values = new ArrayList<>();
            values.add(value);
            expectedResult.put(key, values);
        }

        Map<String, List<String>> actualResult = landingPage.getAllMenuItems();
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
