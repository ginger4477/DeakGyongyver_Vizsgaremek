package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Roxo Webpage testing")
@Feature("Handle Terms And Conditions test")
public class TermsAndConditionsTest extends TestEnvironment {


    @Test
    @Description("Terms and Conditions pop up window is displayed")
    @Story("Popup window of Terms and Conditions")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC02 - Terms and Conditions PopUp window is displayed")
    void displayTermsAndConditionsPopUp() {
        registrationAndLoginPage.navigateTo();

        makeScreenshot("Terms andConditions popup window is displayed");
        Assertions.assertTrue(registrationAndLoginPage.isTnCPopupDisplayed(), "Popup window isn't displayed");
    }


    @Test
    @Description("Accept Terms and Conditions")
    @Story("Popup window of Terms and Conditions")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC03 - Accept and Validate Terms and Conditions PopUp window")
    void acceptTermsAndConditions() {
        registrationAndLoginPage.navigateTo();

        registrationAndLoginPage.acceptTermsNConditions();
        makeScreenshot("Terms and Conditions pop up window disappeared after accept is");
        Assertions.assertFalse(registrationAndLoginPage.isTnCPopupDisplayed(), "Accept terms and conditions failed");
    }


}
