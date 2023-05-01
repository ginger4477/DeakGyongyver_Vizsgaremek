package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class PortfolioPage extends Page{

    // LOCATORS
    private static final By PROJECT_NAMES = By.xpath("//h3");
    private static final By BUTTON_NEXT_PAGE_ACTIVE = By.xpath("//*[@aria-label='Next']");
    private static final By READ_MORE_KIO_TAPE_BRAND = By.xpath("//*[@id=\"project\"]/div/div/div[1]/div/div[2]/a");
    private static final By CONTENT_PORTFOLIO_KIO_TAPE_BRAND = By.xpath("//*[@class='site-project-single']");
    private static final By PHOTOS_KIO_TAPE_BRAND = By.cssSelector(".site-project-single-image img");
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



    // Save one or multiple image with unique name
    public void saveKioTapeImages() {
        List<WebElement> images = findElementsOnPage(PHOTOS_KIO_TAPE_BRAND);
        for (int i = 0; i < images.size(); i++) {
            String src = images.get(i).getAttribute("src");
            try {
                URL imageURL = new URL(src);
                BufferedImage saveImage = ImageIO.read(imageURL);
                ImageIO.write(saveImage, "png", new File("actualKioTapeImage" + (i + 1) + ".png"));
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }


}
