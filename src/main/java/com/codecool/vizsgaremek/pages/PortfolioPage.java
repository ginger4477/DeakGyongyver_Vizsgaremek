package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PortfolioPage extends Page{

    // LOCATORS
    private static final By PROJECT_NAMES = By.xpath("//h3");
    private static final By BUTTON_NEXT_PAGE_ACTIVE = By.xpath("//*[@aria-label='Next']");
    private static final By READ_MORE_KIO_TAPE_BRAND = By.xpath("//*[@id=\"project\"]/div/div/div[1]/div/div[2]/a");
    private static final By CONTENT_PORTFOLIO_KIO_TAPE_BRAND = By.xpath("//*[@class='site-project-single']");


    // Constructor
    public PortfolioPage(WebDriver driver) {
        super(Pages.PORTFOLIO_PAGE.getUrl(), driver);
    }




}
