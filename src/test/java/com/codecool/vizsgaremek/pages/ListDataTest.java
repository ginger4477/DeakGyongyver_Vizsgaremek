package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("List data tests")
public class ListDataTest extends TestEnvironment {

    @BeforeEach
    void performLoginBeforeTest() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    @Description("List team members")
    @Story("Compare two lists of team members")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("List team members")
    void listTeamMembers() {
        landingPage.navigateToAboutPage();
        Assertions.assertEquals(Pages.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"PABLO ESCOBAR", "MONTINO RIAU", "ALEX NAASRI", "HONGMAN CHIOA", "SANTIO ANDRESS", "RAMESH PAUL"};

        makeScreenshot("List team members");
        Assertions.assertArrayEquals(expected, aboutPage.listTeamMembers());
    }



    @Test
    @Description("List expertises")
    @Story("Compare two lists of expertises")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("List expertises")
    void listExpertises() {
        landingPage.navigateToAboutPage();
        Assertions.assertEquals(Pages.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"Customer Experience Design", "Digital Products", "Development", "Campaign & Content",
                                "Employer Branding", "Animation & Motion Graphics", "Packaging & Product Design",
                                "Retail & Spacial", "Print & Editorial Design", "Concept/Text", "Information Design"};

        makeScreenshot("List expertises");
        Assertions.assertArrayEquals(expected, aboutPage.listExpertises());
    }

}
