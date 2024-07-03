package com.softserve.edu.teachua.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;


import java.time.Duration;
import java.util.List;

public class LoggedDropdown {

    private WebElement addClubLink;
    private WebElement addCenterLink;
    private WebElement searchCertificatesLink;
    private WebElement personalProfileLink;
    private WebElement signOutLink;
    private final Search search;

    public LoggedDropdown() {
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        addClubLink = search.cssSelector("li[data-menu-id*='club'] > span.ant-dropdown-menu-title-content");
        addCenterLink = search.cssSelector("li[data-menu-id*='centre'] > span");
        searchCertificatesLink = search.cssSelector("li[data-menu-id*='certificates'] > span");
        personalProfileLink = search.cssSelector("li[data-menu-id*='profile'] > span");
        signOutLink = search.cssSelector("li[data-menu-id*='logout'] > span");
    }

    // Page Object

    // addClubLink;
    public WebElement getAddClubLink() {
        return addClubLink;
    }

    public String getAddClubLinkText() {
        return getAddClubLink().getText();
    }

    public void clickAddClubLink() {
        getAddClubLink().click();
    }

    // addCenterLink;
    public WebElement getAddCenterLink() {
        return addCenterLink;
    }

    public String getAddCenterLinkText() {
        return getAddCenterLink().getText();
    }

    public void clickAddCenterLink() {
        getAddCenterLink().click();
    }

    // searchCertificatesLink;
    public WebElement getSearchCertificatesLink() {
        return searchCertificatesLink;
    }

    public String getSearchCertificatesLinkText() {
        return getSearchCertificatesLink().getText();
    }

    public void clickSearchCertificatesLink() {
        getSearchCertificatesLink().click();
    }

    // personalProfileLink;
    public WebElement getPersonalProfileLink() {
        return personalProfileLink;
    }

    public String getPersonalProfileLinkText() {
        return getPersonalProfileLink().getText();
    }

    public void clickPersonalProfileLink() {
        getPersonalProfileLink().click();
    }

    // signOutLink;
    public WebElement getSignOutLink() {
        return signOutLink;
    }

    public String getSignOutLinkText() {
        return getSignOutLink().getText();
    }

    public void clickSignOutLink() {
        getSignOutLink().click();
    }

    // Functional

    // Business Logic

}