package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Epic("Roxo Webpage testing")
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

        makeScreenshot("Screenshot of the Roxo content on the About page");

        String newFileName = "src/test/resources/savedFiles/savedRoxo.txt";
        String roxoContent = aboutPage.getAboutRoxoContent();
        writeTextToFile(roxoContent, newFileName);

        String expectedResultOfSave = aboutPage.getAboutRoxoContent();
        String actualResultOfSave = Files.readString(Paths.get(newFileName));
        Assertions.assertEquals(expectedResultOfSave, actualResultOfSave, "The expected result of save does not match with the actual one");
    }



    @Test
    @Description("Save Design Inspiration content to a file")
    @Story("Save Design Inspiration content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC25 - Save Design Inspiration content")
    void saveDesignInspirationBlogToAFile() throws IOException {
        landingPage.navigateToBlogPage();
        Assertions.assertEquals(Pages.BLOG_PAGE.getUrl(), driver.getCurrentUrl());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 205)", "");
        makeScreenshot("Screenshot of the blog page with the Design inspiration preview");

        blogPage.clickOnReadMoreButton();

        String newFileName = "src/test/resources/savedFiles/savedDesignInspiration.txt";
        String designInspirationContent = blogPage.getDesignInspirationContent();
        writeTextToFile(designInspirationContent, newFileName);

        makeScreenshot("Screenshot of the Design inspiration blog #1");
        js.executeScript("window.scrollBy(0, 650)", "");
        makeScreenshot("Screenshot of the Design inspiration blog #2");
        js.executeScript("window.scrollBy(0, 300)", "");
        makeScreenshot("Screenshot of the Design inspiration blog #3");

        String expectedResultOfSave = blogPage.getDesignInspirationContent();
        String actualResultOfSave = Files.readString(Paths.get(newFileName));
        Assertions.assertEquals(expectedResultOfSave ,actualResultOfSave, "The expected result of save does not match with the actual one");
    }



    @Test
    @Description("Save Kio Tape Brand content to a file")
    @Story("Save Kio Tape Brand content to a file and validate it")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC26 - Save Kio Tape Brand content")
    void saveKioTapeBrandPortfolioToAFile() throws IOException {
        landingPage.navigateToPortfolioPage();
        Assertions.assertEquals(Pages.PORTFOLIO_PAGE.getUrl(), driver.getCurrentUrl());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400)", "");
        makeScreenshot("Screenshot of the Portfolio page with the Kio Tape's portfolio preview");

        portfolioPage.clickOnReadMoreButton();

        String newFileName = "src/test/resources/savedFiles/savedKioTapeBrand.txt";
        String kioTapeBrandContent = portfolioPage.getKioTapeBrandContent();
        writeTextToFile(kioTapeBrandContent, newFileName);

        makeScreenshot("Screenshot of the Kio Tape Brand's portfolio #1");
        js.executeScript("window.scrollBy(0, 650)", "");
        makeScreenshot("Screenshot of the Kio Tape Brand's portfolio #2");
        js.executeScript("window.scrollBy(0, 600)", "");
        makeScreenshot("Screenshot of the Kio Tape Brand's portfolio #3");

        String expectedResultOfSave = portfolioPage.getKioTapeBrandContent();
        String actualResultOfSave = Files.readString(Paths.get(newFileName));
        Assertions.assertEquals(expectedResultOfSave, actualResultOfSave, "The expected result of save does not match with the actual one");
    }


}
