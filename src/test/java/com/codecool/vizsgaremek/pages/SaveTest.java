package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Feature("Save data tests")
public class SaveTest extends TestEnvironment {

    @BeforeEach
    void performLoginBeforeTest() {
        registrationAndLoginPage.acceptTermsNConditions();
        registrationAndLoginPage.performLogin(BUILT_IN_USERNAME, BUILT_IN_PASSWORD);
        Assertions.assertEquals(Pages.LANDING_PAGE.getUrl(), driver.getCurrentUrl());
    }


    @Test
    @Description("Save Roxo content to a file")
    @Story("Save Roxo content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Save Roxo content")
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
    @Description("Save Design Inspiration content to a file")
    @Story("Save Design Inspiration content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Save Design Inspiration content")
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
    @Description("Save Kio Tape Brand content to a file")
    @Story("Save Kio Tape Brand content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Save Kio Tape Brand content")
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


    @Test
    @Description("Save Kio Tape Brand photos")
    @Story("Save Kio Tape Brand photos to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Save Kio Tape Brand photos")
    void saveKioTapeBrandPhotos() throws IOException {
        landingPage.navigateToPortfolioPage();
        Assertions.assertEquals(Pages.PORTFOLIO_PAGE.getUrl(), driver.getCurrentUrl());
        portfolioPage.clickOnReadMoreButton();
        portfolioPage.saveKioTapeImages();

        File expectedFile1 = new File("expectedKioTapeImage1.png");
        File actualFile1 = new File("actualKioTapeImage1.png");
        File expectedFile2 = new File("expectedKioTapeImage2.png");
        File actualFile2 = new File("actualKioTapeImage2.png");

        // Check if image files exist
        Assertions.assertTrue(expectedFile1.exists());
        Assertions.assertTrue(actualFile1.exists());
        Assertions.assertTrue(expectedFile2.exists());
        Assertions.assertTrue(actualFile2.exists());

        BufferedImage expectedImage1 = ImageIO.read(expectedFile1);
        BufferedImage actualImage1 = ImageIO.read(actualFile1);
        BufferedImage expectedImage2 = ImageIO.read(expectedFile2);
        BufferedImage actualImage2 = ImageIO.read(actualFile2);

        // Check if the images match
        for (int x = 0; x < expectedImage1.getWidth(); x++) {
            for (int y = 0; y < expectedImage1.getHeight(); y++) {
                int expectedRgb = expectedImage1.getRGB(x, y);
                int actualRgb = actualImage1.getRGB(x, y);
                Assertions.assertEquals(expectedRgb, actualRgb);
            }
        }
        for (int x = 0; x < expectedImage2.getWidth(); x++) {
            for (int y = 0; y < expectedImage2.getHeight(); y++) {
                int expectedRgb2 = expectedImage2.getRGB(x, y);
                int actualRgb2 = actualImage2.getRGB(x, y);
                Assertions.assertEquals(expectedRgb2, actualRgb2);
            }
        }
    }


}
