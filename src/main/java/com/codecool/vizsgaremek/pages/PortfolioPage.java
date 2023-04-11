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


    // Going over multiple page list and collect the projects' name
    public String[] goingOverMultiplePageListAndCollectProjectNames() {
        return goingOverMultiplePageListAndCollectData(PROJECT_NAMES, BUTTON_NEXT_PAGE_ACTIVE);
    }


    // Click on read-more button
    public  void clickOnReadMoreButton() {
        findElementOnPage(READ_MORE_KIO_TAPE_BRAND).click();
    }


    // get and verify KioTape Brand Content
    public String getKioTapeBrandContent() {
        return findElementOnPage(CONTENT_PORTFOLIO_KIO_TAPE_BRAND).getText();
    }



}
