package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoingOverMultiplePageListTest extends TestEnvironment {


    @BeforeEach
    void performLoginBeforeTest() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performLogin(REGISTERED_USERNAME, REGISTERED_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    void collectAllProjectName() {
        landingPage.navigateToPortfolioPage();
        Assertions.assertEquals(Pages.PORTFOLIO_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"KIO-TAPE BRAND", "USE-LESS BRAND", "OSEN CLOCK", "SEAMLESS WATCH", "KIO TAPE"};

        Assertions.assertArrayEquals(expected, portfolioPage.goingOverMultiplePageListAndCollectProjectNames());
    }


    @Test
    void collectAllBlogTitle() {
        landingPage.navigateToBlogPage();
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"Design Inspiration: The Best Projects From December",
                                "The 10 Biggest Rebrands and Logo Designs of 2019",
                                "Design Inspiration: The Best Projects From November",
                                "Pt Chooses Classic Blue for Its Colour of the Year 2020",
                                "The 10 Biggest Product Stories of 2019"};

        Assertions.assertArrayEquals(expected, blogPage.goingOverMultiplePageListAndCollectBlogTitles());
    }

}
