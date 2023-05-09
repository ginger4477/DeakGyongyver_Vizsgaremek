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
    @Story("Popup window of Terms and Conditions display correctly")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC02 - Terms and Conditions PopUp window is displayed")
    void displayTermsAndConditionsPopUp() {
        registrationAndLoginPage.navigateTo();

        makeScreenshot("Result of display terms and conditions pop up window after navigate to the page");
        Assertions.assertTrue(registrationAndLoginPage.isTnCPopupDisplayed(), "Terms and conditions pop up window is displayed: ");
    }



    @Test
    @Description("Accept Terms and Conditions")
    @Story("Popup window of Terms and Conditions disappear after accept is")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC03 - Accept and Validate Terms and Conditions PopUp window")
    void acceptTermsAndConditions() {
        registrationAndLoginPage.navigateTo();

        registrationAndLoginPage.acceptTermsNConditions();
        makeScreenshot("Result of accept the terms and conditions");
        Assertions.assertFalse(registrationAndLoginPage.isTnCPopupDisplayed(), "Terms and conditions pop up window is displayed: ");
    }


}
