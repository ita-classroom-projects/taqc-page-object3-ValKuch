package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class ClubComponent {

    private WebDriver driver;
    private WebElement clubCard;
    //
    private WebElement titleLink;
    private List<WebElement> categoriesLabel;
    private WebElement descriptionLabel;
    private WebElement addressLabel;
    private WebElement detailsButton;
    private final Search search;


    public ClubComponent(WebDriver driver, WebElement clubCard) {
        this.driver = DriverManager.getDriver();
        this.clubCard = clubCard;
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
        titleLink = search.cssSelector("div.title", clubCard);
        categoriesLabel = search.cssSelectors("div.tags.club-tags span.name", clubCard);
        descriptionLabel = search.cssSelector("p.description", clubCard);
        addressLabel = search.cssSelector("div.address", clubCard);
        detailsButton = search.cssSelector("a.details-button > a", clubCard);
    }

    // Page Object

    // titleLink;
    public WebElement getTitleLink() {
        return titleLink;
    }

    public String getTitleLinkText() {
        return getTitleLink().getText();
    }

    public void clickTitleLink() {
        getTitleLink().click();
    }

    // categoriesLabel;
    public List<WebElement> getCategoriesLabel() {
        return categoriesLabel;
    }

    public List<String> getCategoriesLabelText() {
        List<String> categoriesNames = new ArrayList<>();
        for (WebElement current : getCategoriesLabel()) {
            categoriesNames.add(current.getText());
        }
        return categoriesNames;
    }

    // descriptionLabel;
    public WebElement getDescriptionLabel() {
        return descriptionLabel;
    }

    public String getDescriptionLabelText() {
        return getDescriptionLabel().getText();
    }

    // addressLabel
    public WebElement getAddressLabel() {
        return addressLabel;
    }

    public String getAddressLabelText() {
        return getAddressLabel().getText();
    }

    // detailsButton;
    public WebElement getDetailsButton() {
        return detailsButton;
    }

    public String getDetailsButtonText() {
        return getDetailsButton().getText();
    }

    public void clickDetailsButton() {
        getDetailsButton().click();
    }

    // Functional

    // Business Logic

    public ClubInfoModal openClubInfoModal() {
        clickTitleLink();
        return new ClubInfoModal(driver);
    }

    public ClubDetailsPage openClubDetailsPage() {
        clickDetailsButton();
        return new ClubDetailsPage();
    }

}
