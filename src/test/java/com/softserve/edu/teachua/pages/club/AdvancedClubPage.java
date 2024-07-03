package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

public class AdvancedClubPage extends ClubPage {

    private WebElement advancedSearchLabel;
    private final Search search;

    public AdvancedClubPage() {
        super();
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        advancedSearchLabel = search.cssSelector("div.ant-layout-sider-children > div.club-list-label");
    }

    // Page Object

    // advancedSearchLabel
    public WebElement getAdvancedSearchLabel() {
        return advancedSearchLabel;
    }

    public String getAdvancedSearchLabelText() {
        return getAdvancedSearchLabel().getText();
    }

    // Functional

    // Business Logic

    @Override
    public AdvancedClubPage previousClubPagination() {
        clickPreviousClubPagination();
        return this;
    }

    @Override
    public AdvancedClubPage nextClubPagination() {
        clickNextClubPagination();
        return this;
    }
}
