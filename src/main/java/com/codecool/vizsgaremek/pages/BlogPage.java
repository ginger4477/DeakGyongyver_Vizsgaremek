package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends Page {

    // Locators
    static final By BLOG_TITLES = By.xpath("//h3");
    static final By BUTTON_NEXT_PAGE_ACTIVE = By.xpath("//*[@aria-label='Next']");
    private static final By READ_MORE_DESIGN_INSPIRATION = By.xpath("//*[text()='Design Inspiration: The Best Projects From December']");
    private static final By CONTENT_BLOG_DESIGN_INSPIRATION = By.xpath("//*[@class='site-blog-details']");


    // Constructor
    public BlogPage(WebDriver driver) {
        super(Pages.BLOG_PAGE.getUrl(), driver);
    }


    // Going over multiple page list and collect the blog titles
    public String[] goingOverMultiplePageListAndCollectBlogTitles() {
        return goingOverMultiplePageListAndCollectData(BLOG_TITLES, BUTTON_NEXT_PAGE_ACTIVE);
    }


    // Click on read-more button
    public  void clickOnReadMoreButton() {
        findElementOnPage(READ_MORE_DESIGN_INSPIRATION).click();
    }


    // Get and verify Design Inspiration Blog Content
    public String getDesignInspirationContent() {
        return findElementOnPage(CONTENT_BLOG_DESIGN_INSPIRATION).getText();
    }



}