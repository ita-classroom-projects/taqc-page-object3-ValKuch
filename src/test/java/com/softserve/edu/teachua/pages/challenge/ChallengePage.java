package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.tools.DriverManager;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;
import org.openqa.selenium.WebElement;

public abstract class ChallengePage extends TopSearchPart {

    private WebElement bannerLabel;
    private final Search search;


    public ChallengePage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        bannerLabel = search.cssSelector("div.banner span.title");
    }

    // Page Object

    // bannerLabel
    public WebElement getBannerLabel() {
        return bannerLabel;
    }

    public String getBannerLabelText() {
        return getBannerLabel().getText();
    }

    // Functional

    // Business Logic

}
