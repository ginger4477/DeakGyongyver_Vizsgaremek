package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage extends Page{

    // Locators
    private static final By TEAM_MEMBERS = By.xpath("//*[@class='site-team-member-content']/h3");
    private static final By EXPERTISES = By.xpath("//*[@class='site-expertise-list']/li");
    private static final By CONTENT_ABOUT_ROXO = By.className("site-about-wrapper");


    // Constructor
    public AboutPage(WebDriver driver) {
        super(Pages.ABOUT_PAGE.getUrl(), driver);
    }




}
