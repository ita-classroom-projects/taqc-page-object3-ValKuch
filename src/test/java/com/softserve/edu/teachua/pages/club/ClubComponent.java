package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ClubComponent {

    protected WebDriver driver;
    private WebElement clubCard;
    //
    private WebElement titleLink;
    private List<WebElement> categoriesLabel;
    private WebElement descriptionLabel;
    private WebElement addressLabel;
    private WebElement detailsButton;

    public ClubComponent(WebDriver driver, WebElement clubCard) {
        this.driver = driver;
        this.clubCard = clubCard;
        initElements();
    }

    private void initElements() {
        // init elements
        titleLink = clubCard.findElement(By.cssSelector("div.title"));
        categoriesLabel = clubCard.findElements(By.cssSelector("div.tags.club-tags span.name"));
        descriptionLabel = clubCard.findElement(By.cssSelector("p.description"));
        addressLabel = clubCard.findElement(By.cssSelector("div.address"));
        detailsButton = clubCard.findElement(By.cssSelector("a.details-button > a"));
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
        return new ClubDetailsPage(driver);
    }

}
