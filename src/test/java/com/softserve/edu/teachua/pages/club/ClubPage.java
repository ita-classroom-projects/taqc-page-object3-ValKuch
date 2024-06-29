package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.data.Cities;
import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClubPage extends TopSearchPart {

    private ClubsContainer clubsContainer;

    public ClubPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        clubsContainer = new ClubsContainer(driver);
    }

    // Page Object

    // clubsContainer
    public ClubsContainer getClubContainer() {
        return clubsContainer;
    }

    // Functional

    public boolean isExistClubByPartialTitle(String partialTitle) {
        boolean isFound = getClubContainer().isExistClubComponentByPartialTitle(partialTitle);
        while (!isFound && getClubContainer().isEnableNextPageLink()) {
            getClubContainer().clickNextPageLink();
            initElements();
            isFound = getClubContainer().isExistClubComponentByPartialTitle(partialTitle);
        }
        return isFound;
    }

    public void clickPreviousClubPagination() {
        if (!getClubContainer().isEnablePreviousPageLink()) {
            // TODO Develop Custom Exception
            throw new RuntimeException("The previous page is not available");
        }
        getClubContainer().clickPreviousPageLink();
    }

    public void clickNextClubPagination() {
        if (!getClubContainer().isEnableNextPageLink()) {
            // TODO Develop Custom Exception
            throw new RuntimeException("The next page is not available");
        }
        getClubContainer().clickNextPageLink();
    }

    // Business Logic

    /*
    public ClubPage chooseCity(Cities city) {
        // Move to TopPart
        return new ClubPage(driver);
    }
    */

    public ClubPage previousClubPagination() {
        clickPreviousClubPagination();
        return new ClubPage(driver);
    }

    public ClubPage nextClubPagination() {
        clickNextClubPagination();
        return new ClubPage(driver);
    }

    public ClubPage chooseClubPaginationNumber(int numberPage) {
        getClubContainer().clickPageLinkByNumber(numberPage);
        return new ClubPage(driver);
    }

}
