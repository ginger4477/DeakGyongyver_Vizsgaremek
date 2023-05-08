package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Roxo Webpage testing")
@Feature("Basic test")
public class BasicTest extends TestEnvironment {

    @Test
    @Description("Arrive at the correct URL")
    @Story("The user is navigate to the correct URL")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC01 - Arrive correct URL")
    void arriveCorrectUrl() {
        registrationAndLoginPage.navigateTo();

        makeScreenshot("Landing on correct URL for start using Roxo webpage");
        Assertions.assertEquals(Pages.REGISTRATION_AND_LOGIN_PAGE.getUrl(), driver.getCurrentUrl(), "Landing url for Roxo webpage:");
    }

}
