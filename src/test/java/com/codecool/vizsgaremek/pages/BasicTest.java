package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Feature("Basic test")
public class BasicTest extends TestEnvironment {


    @Test
    @Description("Arrive at the correct URL")
    @Story("The user is navigate to the correct URL")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Arrive correct URL")
    void arriveCorrectUrl() {
        makeScreenshot("Landing on correct URL");
        Assertions.assertEquals(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl());
    }


}
