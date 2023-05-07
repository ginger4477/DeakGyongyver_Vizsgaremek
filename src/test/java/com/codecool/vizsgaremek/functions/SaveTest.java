package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Feature("Save data tests")
public class SaveTest extends TestEnvironment {

    @BeforeEach
    void performLoginBeforeTest() {
        registrationAndLoginPage.navigateTo();
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    @Description("Save Roxo content to a file")
    @Story("Save Roxo content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC24 - Save Roxo content")
    void saveAboutRoxoContentToAFile() throws IOException {
        landingPage.navigateToAboutPage();
        Assertions.assertEquals(Pages.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        String newFileName = "Roxo.txt";
        String roxoContent = aboutPage.getAboutRoxoContent();
        writeTextToFile(roxoContent, newFileName);

        String expectedResultOfSave = aboutPage.getAboutRoxoContent();
        String actualResultOfSave = Files.readString(Paths.get(newFileName));
        Assertions.assertEquals(expectedResultOfSave, actualResultOfSave);
    }


    @Test
    @Description("Save Design Inspiration content to a file")
    @Story("Save Design Inspiration content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC25 - Save Design Inspiration content")
    void saveDesignInspirationBlogToAFile() throws IOException {
        landingPage.navigateToBlogPage();
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());
        blogPage.clickOnReadMoreButton();

        String newFileName = "designInspiration.txt";
        String designInspirationContent = blogPage.getDesignInspirationContent();
        writeTextToFile(designInspirationContent, newFileName);

        String expectedResultOfSave = blogPage.getDesignInspirationContent();
        String actualResultOfSave = Files.readString(Paths.get(newFileName));
        Assertions.assertEquals(expectedResultOfSave ,actualResultOfSave);
    }


    @Test
    @Description("Save Kio Tape Brand content to a file")
    @Story("Save Kio Tape Brand content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC26 - Save Kio Tape Brand content")
    void saveKioTapeBrandPortfolioToAFile() throws IOException {
        landingPage.navigateToPortfolioPage();
        Assertions.assertEquals(Pages.PORTFOLIO_PAGE.getUrl(), driver.getCurrentUrl());
        portfolioPage.clickOnReadMoreButton();

        String newFileName = "kioTapeBrand.txt";
        String kioTapeBrandContent = portfolioPage.getKioTapeBrandContent();
        writeTextToFile(kioTapeBrandContent, newFileName);

        String expectedResultOfSave = portfolioPage.getKioTapeBrandContent();
        String actualResultOfSave = Files.readString(Paths.get(newFileName));
        Assertions.assertEquals(expectedResultOfSave, actualResultOfSave);
    }


}
