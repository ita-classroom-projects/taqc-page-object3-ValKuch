package com.softserve.edu.teachua.pages.menu;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;
public class NewsPage extends TopSearchPart {

    private WebElement cityNewsLabel;
    private final Search search;

    public NewsPage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
        cityNewsLabel = search.cssSelector("div.club-sider h2.city-name");
    }

    // Page Object

    // cityNewsLabel
    public WebElement getCityNewsLabel() {
        return cityNewsLabel;
    }

    public String getCityNewsLabelText() {
        return getCityNewsLabel().getText();
    }

    // Functional

    // Business Logic

}
