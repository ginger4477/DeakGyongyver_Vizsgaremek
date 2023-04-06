package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Feature("Terms And Conditions")
public class TermsAndConditionsTest extends TestEnvironment {


    @Test
    @Description("Terms and Conditions pop up window is displayed")
    @Story("Popup window of Terms and Conditions")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Terms and Conditions PopUp window is displayed")
    void displayTermsAndConditionsPopUp() {
        makeScreenshot("Terms andConditions popup window is displayed");
        Assertions.assertTrue(registrationAndLoginPage.isTnCPopupDisplayed());
    }


    @Test
    @Description("Accept Terms and Conditions")
    @Story("Popup window of Terms and Conditions")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Accept and Validate Terms and Conditions PopUp window")
    void acceptTermsAndConditions() {
        registrationAndLoginPage.acceptTermsNConditions();
        makeScreenshot("Terms and Conditions pop up window disappeared after accept is");
        Assertions.assertFalse(registrationAndLoginPage.isTnCPopupDisplayed());
    }



}
