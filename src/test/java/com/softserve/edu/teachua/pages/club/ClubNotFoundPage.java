package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

public class ClubNotFoundPage extends TopSearchPart {

    public static String NOT_FOUND_MESSAGE = "За критеріями пошуку гуртків не знайдено";

    private WebElement notFoundLabel;
    private final Search search;

    public ClubNotFoundPage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // Initialize elements
        notFoundLabel = search.cssSelector("div.clubs-not-found");
    }

    // Page Object

    // notFoundLabel
    public WebElement getNotFoundLabel() {
        return notFoundLabel;
    }

    public String getNotFoundLabelText() {
        return getNotFoundLabel().getText();
    }

    // Functional

    // Business Logic

}
