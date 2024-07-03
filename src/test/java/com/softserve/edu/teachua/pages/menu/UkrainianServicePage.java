package com.softserve.edu.teachua.pages.menu;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

public class UkrainianServicePage extends TopSearchPart {

    private WebElement faqTitleLabel;
    private final Search search;

    public UkrainianServicePage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
        faqTitleLabel = search.cssSelector("div.faq-title");
    }

    // Page Object

    // faqTitleLabel
    public WebElement getFaqTitleLabel() {
        return faqTitleLabel;
    }

    public String getFaqTitleLabelText() {
        return getFaqTitleLabel().getText();
    }

    // Functional

    // Business Logic

}
