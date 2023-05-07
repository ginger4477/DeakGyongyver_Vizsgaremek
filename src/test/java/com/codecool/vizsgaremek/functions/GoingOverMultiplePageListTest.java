package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Feature("Going-over multiple-page list tests")
public class GoingOverMultiplePageListTest extends TestEnvironment {


    @BeforeEach
    void performLoginBeforeTest() {
        registrationAndLoginPage.navigateTo();
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    @Description("Going over multiple page list and collect project names")
    @Story("Going over multiple page list and collect project names")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC19 - Collect all projects")
    void collectAllProjectName() {
        landingPage.navigateToPortfolioPage();
        Assertions.assertEquals(Pages.PORTFOLIO_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"KIO-TAPE BRAND", "USE-LESS BRAND", "OSEN CLOCK", "SEAMLESS WATCH", "KIO TAPE"};

        Assertions.assertArrayEquals(expected, portfolioPage.goingOverMultiplePageListAndCollectProjectNames(), "Project names are incorrect");
    }


    @Test
    @Description("Going over multiple page list and collect blog titles")
    @Story("Going over multiple page list and collect blog titles")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC20 - Collect all blog titles")
    void collectAllBlogTitle() {
        landingPage.navigateToBlogPage();
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"Design Inspiration: The Best Projects From December",
                                "The 10 Biggest Rebrands and Logo Designs of 2019",
                                "Design Inspiration: The Best Projects From November",
                                "Pt Chooses Classic Blue for Its Colour of the Year 2020",
                                "The 10 Biggest Product Stories of 2019"};

        Assertions.assertArrayEquals(expected, blogPage.goingOverMultiplePageListAndCollectBlogTitles(), "Blog titles are incorrect");
    }


}
