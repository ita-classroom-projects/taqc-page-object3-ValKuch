package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedClubPage extends ClubPage {

    private WebElement advancedSearchLabel;

    public AdvancedClubPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        advancedSearchLabel = driver.findElement(By.cssSelector("div.ant-layout-sider-children > div.club-list-label"));
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
        return new AdvancedClubPage(driver);
    }

    @Override
    public AdvancedClubPage nextClubPagination() {
        clickNextClubPagination();
        return new AdvancedClubPage(driver);
    }
}
