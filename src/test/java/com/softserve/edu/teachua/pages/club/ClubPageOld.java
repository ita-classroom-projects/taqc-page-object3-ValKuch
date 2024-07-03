package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

// Only one club page. Update next time


public class ClubPageOld extends TopSearchPart {
    private WebDriver driver;

    private WebElement clubTitleLink;
    private WebElement clubDescriptionLabel;
    private WebElement clubDetailsLink;
    private final Search search;

    public ClubPageOld() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
        clubTitleLink = search.cssSelector("div.ant-card.ant-card-bordered.card div.name");
        clubDescriptionLabel = search.cssSelector("p.description");
        clubDetailsLink = search.cssSelector("a.details-button > a");
    }

    // Page Object

    // clubTitleLink;
    public WebElement getClubTitleLink() {
        return clubTitleLink;
    }

    public String getClubTitleLinkText() {
        return getClubTitleLink().getText();
    }

    public void clickClubTitleLink() {
        getClubTitleLink().click();
    }

    // clubDescriptionLabel;
    public WebElement getClubDescriptionLabel() {
        return clubDescriptionLabel;
    }

    public String getClubDescriptionLabelText() {
        return getClubDescriptionLabel().getText();
    }

    public void clickClubDescriptionLabel() {
        getClubDescriptionLabel().click();
    }

    // clubDetailsLink;
    public WebElement getClubDetailsLink() {
        return clubDetailsLink;
    }

    public String getClubDetailsLinkText() {
        return getClubDetailsLink().getText();
    }

    public void clickClubDetailsLink() {
        getClubDetailsLink().click();
    }

    // Functional

    // Business Logic

    public ClubInfoModal openClubInfoModal() {
        clickClubTitleLink();
        return new ClubInfoModal(driver);
    }

    public ClubDetailsPage gotoClubDetailsPage() {
        clickClubDetailsLink();
        return new ClubDetailsPage();
    }
}
