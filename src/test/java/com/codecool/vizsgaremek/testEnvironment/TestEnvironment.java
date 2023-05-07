package com.codecool.vizsgaremek.testEnvironment;

import com.codecool.vizsgaremek.WebDriverFactory;
import com.codecool.vizsgaremek.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;


public class TestEnvironment {


    protected WebDriver driver;

    protected RegistrationAndLoginPage registrationAndLoginPage;

    protected LandingPage landingPage;
    protected AboutPage aboutPage;
    protected ContactPage contactPage;
    protected PortfolioPage portfolioPage;
    protected BlogPage blogPage;
    protected ProfilePage profilePage;
    protected static final String BUILT_IN_USERNAME = "lovasia";
    protected static final String BUILT_IN_PASSWORD = "kispal123";
    protected static final String TEST_USERNAME = "hópihe";
    protected static final String TEST_PASSWORD = "hahópihe";
    protected static final String TEST_EMAIL = "hopihe@testmail.com";
    protected static final String TEST_DESCRIPTION = "Once upon a time, there was a little 'hópihe'";


    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setUp() {
        driver = WebDriverFactory.getWebDriver();

        registrationAndLoginPage = new RegistrationAndLoginPage(driver);
        landingPage = new LandingPage(driver);
        aboutPage = new AboutPage(driver);
        contactPage = new ContactPage(driver);
        portfolioPage = new PortfolioPage(driver);
        blogPage = new BlogPage(driver);
        profilePage = new ProfilePage(driver);
    }



    // Write text to a File
    protected void writeTextToFile(String content, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing text to file: " + e.getMessage());
        }
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }


    // make screenshot
    protected void makeScreenshot(String title){
        Allure.addAttachment(title, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


}
