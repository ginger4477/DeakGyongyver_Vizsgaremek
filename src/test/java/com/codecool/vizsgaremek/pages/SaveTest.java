package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveTest extends TestEnvironment {

    @BeforeEach
    void performLoginBeforeTest() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performLogin(REGISTERED_USERNAME, REGISTERED_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    void saveAboutRoxoContentToAFile() throws IOException {
        landingPage.navigateToAboutPage();
        Assertions.assertEquals(Pages.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        String newFileName = "Roxo.txt";
        String roxoContent = aboutPage.getAboutRoxoContent();
        writeTextToFile(roxoContent, newFileName);

        String actualResultOfSave = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(aboutPage.getAboutRoxoContent(), actualResultOfSave);
    }


    @Test
    void saveDesignInspirationBlogToAFile() throws IOException {
        landingPage.navigateToBlogPage();
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        blogPage.clickOnReadMoreButton();

        String newFileName = "designInspiration.txt";
        String designInspirationContent = blogPage.getDesignInspirationContent();
        writeTextToFile(designInspirationContent, newFileName);

        String actualResultOfSave = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(blogPage.getDesignInspirationContent(), actualResultOfSave);
    }


    @Test
    void saveKioTapeBrandPortfolioToAFile() throws IOException {
        landingPage.navigateToPortfolioPage();
        Assertions.assertEquals(Pages.PORTFOLIO_PAGE.getUrl(), driver.getCurrentUrl());
        portfolioPage.clickOnReadMoreButton();

        String newFileName = "kioTapeBrand.txt";
        String kioTapeBrandContent = portfolioPage.getKioTapeBrandContent();
        writeTextToFile(kioTapeBrandContent, newFileName);

        String actualResultOfSave = Files.readString(Paths.get(newFileName));

        Assertions.assertEquals(portfolioPage.getKioTapeBrandContent(), actualResultOfSave);
    }



}
