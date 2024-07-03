package com.softserve.edu.teachua.pages.menu;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

public class AboutUsPage extends TopSearchPart {

    private WebElement ourContactLabel;
    private final Search search;

    public AboutUsPage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
        ourContactLabel = search.cssSelector("div.social-media span.text");
    }

    // Page Object

    // ourContactLabel
    public WebElement getOurContactLabel() {
        return ourContactLabel;
    }

    public String getOurContactLabelText() {
        return getOurContactLabel().getText();
    }

    // Functional

    // Business Logic

}
