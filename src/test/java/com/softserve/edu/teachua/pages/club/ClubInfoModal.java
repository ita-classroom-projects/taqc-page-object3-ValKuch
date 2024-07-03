package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

public class ClubInfoModal {

    private WebElement ariaCloseButton;
    private WebElement clubTitleLabel;
    private WebElement clubMoreButton;
    private WebElement clubDescriptionLabel;
    private final Search search;

    public ClubInfoModal(WebDriver driver) {
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
        ariaCloseButton = search.cssSelector("button[aria-label='Close']");
        clubTitleLabel = search.cssSelector("div.title div.club-name");
        clubMoreButton = search.cssSelector("button.more-button");
        clubDescriptionLabel = search.cssSelector("div.about-club div.description");
    }

    // Page Object

    // ariaCloseButton
    public WebElement getAriaCloseButton() {
        return ariaCloseButton;
    }

    public void clickAriaCloseButton() {
        getAriaCloseButton().click();
    }

    // clubTitleLabel;
    public WebElement getClubTitleLabel() {
        return clubTitleLabel;
    }

    public String getClubTitleLabelText() {
        return getClubTitleLabel().getText();
    }

    // clubMoreButton;
    public WebElement getClubMoreButton() {
        return clubMoreButton;
    }

    public String getClubMoreButtonText() {
        return getClubMoreButton().getText();
    }

    public void clickClubMoreButton() {
        getClubMoreButton().click();
    }

    // clubDescriptionLabel
    public WebElement getClubDescriptionLabel() {
        return clubDescriptionLabel;
    }

    public String getClubDescriptionLabelText() {
        return getClubDescriptionLabel().getText();
    }

    // Functional

    // Business Logic

    public ClubPage closeClubInfoModal() {
        clickAriaCloseButton();
        return new ClubPage();
    }

    public ClubDetailsPage gotoClubDetailsPage() {
        clickClubMoreButton();
        return new ClubDetailsPage();
    }

}

