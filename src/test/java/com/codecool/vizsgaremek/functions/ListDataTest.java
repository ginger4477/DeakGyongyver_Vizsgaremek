package com.codecool.vizsgaremek.functions;

import com.codecool.vizsgaremek.enums.Pages;
import com.codecool.vizsgaremek.testEnvironment.TestEnvironment;
import io.qameta.allure.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Epic("Roxo Webpage testing")
@Feature("List data tests")
public class ListDataTest extends TestEnvironment {

    @BeforeEach
    void navigateToAboutPage() {
        driver.navigate().to(Pages.ABOUT_PAGE.getUrl());
    }


    @Test
    @Description("List team members")
    @Story("Compare two lists of team members")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC21 - List team members")
    void listTeamMembers() {
        Assertions.assertEquals(Pages.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"PABLO ESCOBAR", "MONTINO RIAU", "ALEX NAASRI", "HONGMAN CHIOA", "SANTIO ANDRESS", "RAMESH PAUL"};

        makeScreenshot("List team members");
        Assertions.assertArrayEquals(expected, aboutPage.listTeamMembers(), "Team members list is incorrect");
    }


    @Test
    @Description("Team members business card checking")
    @Story("Check if the team members' business card is valid")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC22 - Team members' business card validation")
    void membersBusinessCardTest() throws IOException, ParseException {
        Assertions.assertEquals(Pages.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/teamMembers.json"));
        JSONArray members = (JSONArray) obj;

        Map<String, String> expectedResult = new HashMap<>();
        for(Object member : members) {

            String key = (String) ((JSONObject) member).get("name");
            String value = (String) ((JSONObject) member).get("profession");

            expectedResult.put(key, value);
        }

        makeScreenshot("Team members' business cards");

        Assertions.assertEquals(expectedResult, aboutPage.getMembers(), "The map returned by getMembers() does not match the expected result");
    }




    @Test
    @Description("List expertises")
    @Story("Compare two lists of expertises")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC23 - List expertises")
    void listExpertises() {
        Assertions.assertEquals(Pages.ABOUT_PAGE.getUrl(), driver.getCurrentUrl());

        String[] expected = {"Customer Experience Design", "Digital Products", "Development", "Campaign & Content",
                                "Employer Branding", "Animation & Motion Graphics", "Packaging & Product Design",
                                "Retail & Spacial", "Print & Editorial Design", "Concept/Text", "Information Design"};

        makeScreenshot("List expertises");
        Assertions.assertArrayEquals(expected, aboutPage.listExpertises(), "List of expertises is incorrect");
    }


}
