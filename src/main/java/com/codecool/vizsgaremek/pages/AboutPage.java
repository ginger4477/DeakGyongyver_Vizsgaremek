package com.codecool.vizsgaremek.pages;

import com.codecool.vizsgaremek.enums.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AboutPage extends Page{

    // Locators
    private static final By TEAM_MEMBERS = By.xpath("//*[@class='site-team-member-content']/h3");
    private static final By EXPERTISES = By.xpath("//*[@class='site-expertise-list']/li");
    private static final By CONTENT_ABOUT_ROXO = By.className("site-about-wrapper");
    private static final By TEAM_MEMBERS_BUSINESS_CARDS = By.className("site-team-member-content");


    // Constructor
    public AboutPage(WebDriver driver) {
        super(Pages.ABOUT_PAGE.getUrl(), driver);
    }



    // Method for listing datas
    private String[] listingData(By locator) {
        List<WebElement> datas = findElementsOnPage(locator);
        String[] resultArray = new String[datas.size()];
        int count = 0;
        for(WebElement data : datas) {
            resultArray[count++] = data.getText();
        }
        return resultArray;
    }

    // Listing team members
    public String[] listTeamMembers() {
        return listingData(TEAM_MEMBERS);
    }

    // Listing expertises
    public String[] listExpertises() {
        return listingData(EXPERTISES);
    }


    //Get all the team members and their professions from the About page
    public Map<String, String> getMembers() {
        List<WebElement> memberCards = findElementsOnPage(TEAM_MEMBERS_BUSINESS_CARDS);

        Map<String, String> members = new HashMap<>();

        // Loop through all the team member cards and add their name and profession to the map
        for (WebElement memberCard : memberCards) {
            members.put(memberCard.findElement(By.tagName("h3")).getText(), memberCard.findElement(By.tagName("p")).getText());
        }

        return members;
    }


    // Get and verify About Roxo Content
    public String getAboutRoxoContent() {
        return findElementOnPage(CONTENT_ABOUT_ROXO).getText();
    }

}
