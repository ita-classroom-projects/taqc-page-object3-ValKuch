package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ClubsContainer {

    public final String CLUBS_NOT_FOUND = "There is no club that matches the search criteria.";
    private final String CLUBS_COMPONENT_CSSSELECTOR = "div.ant-card.ant-card-bordered";
    //private final String PAGINATION_NUMBERS = "li[title='%d'] > a";
    private final String PAGINATION_NUMBERS_XPATHSELECTOR =
            "//li[contains(@class,'ant-pagination-item')]/a[text()='%d']";
    //
    protected WebDriver driver;
    //
    private List<ClubComponent> clubComponents;
    private WebElement previousItem;
    private WebElement nextItem;
    private WebElement previousPageLink;
    private WebElement nextPageLink;

    public ClubsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // init elements
        clubComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(CLUBS_COMPONENT_CSSSELECTOR))) {
            clubComponents.add(new ClubComponent(driver, current));
        }
        if (clubComponents.size() == 0) {
            throw new RuntimeException(CLUBS_NOT_FOUND);
        }
        previousItem = driver.findElement(By.cssSelector("li[title='Previous Page']"));
        nextItem = driver.findElement(By.cssSelector("li[title='Next Page']"));
        previousPageLink = driver.findElement(By.cssSelector("li[title='Previous Page'] > button"));
        nextPageLink = driver.findElement(By.cssSelector("li[title='Next Page'] > button"));
    }

    // Page Object

    // clubComponents
    public List<ClubComponent> getClubComponents() {
        return clubComponents;
    }

    // previousItem

    public WebElement getPreviousItem() {
        return previousItem;
    }

    public String getPreviousItemClassAttribute() {
        return getPreviousItem().getAttribute(TopPart.TAG_ATTRIBUTE_CLASS);
    }

    public boolean isEnablePreviousPageLink() {
        return !getPreviousItemClassAttribute().contains("pagination-disabled");
        //return true;
    }

    // nextItem
    public WebElement getNextItem() {
        return nextItem;
    }

    public String getNextItemClassAttribute() {
        return getNextItem().getAttribute(TopPart.TAG_ATTRIBUTE_CLASS);
    }

    public boolean isEnableNextPageLink() {
        return !getNextItemClassAttribute().contains("pagination-disabled");
        //return true;
    }

    // previousPageLink
    public WebElement getPreviousPageLink() {
        return previousPageLink;
    }

    public String getPreviousPageLinkText() {
        return getPreviousPageLink().getText();
    }

    public void clickPreviousPageLink() {
        getPreviousPageLink().click();
    }

    // nextPageLink
    public WebElement getNextPageLink() {
        return nextPageLink;
    }

    public String getNextPageLinkText() {
        return getNextPageLink().getText();
    }

    public void clickNextPageLink() {
        getNextPageLink().click();
    }

    // Functional

    public int getClubComponentsCount() {
        return getClubComponents().size();
    }

    public List<String> getClubComponentTitles() {
        List<String> clubComponentNames = new ArrayList<>();
        for (ClubComponent current : getClubComponents()) {
            clubComponentNames.add(current.getTitleLinkText());
        }
        return clubComponentNames;
    }

    public ClubComponent getFirstClubComponent() {
        if (getClubComponentsCount() == 0) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException(CLUBS_NOT_FOUND);
        }
        return  getClubComponents().get(0);
    }

    public ClubComponent getClubComponentByTitle(String clubTitle) {
        ClubComponent result = null;
        for (ClubComponent current : getClubComponents()) {
            if (current.getTitleLinkText().toLowerCase()
                    .equals(clubTitle.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("ClubTitle: " + clubTitle + " not Found.");
        }
        return result;
    }

    public ClubComponent getClubComponentByPartialTitle(String partialTitle) {
        ClubComponent result = null;
        for (ClubComponent current : getClubComponents()) {
            if (current.getTitleLinkText().toLowerCase()
                    .contains(partialTitle.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("Club partialTitle: " + partialTitle + " not Found.");
        }
        return result;
    }

    public boolean isExistClubComponentByPartialTitle(String partialTitle) {
        boolean isFound = false;
        for (String current : getClubComponentTitles()) {
            if (current.toLowerCase().contains(partialTitle.toLowerCase())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public void clickPageLinkByNumber(int numberPage) {
        WebElement pageLink = null;
        List<WebElement> paginationNumbers = driver.findElements(By
                .xpath(String.format(PAGINATION_NUMBERS_XPATHSELECTOR, numberPage)));
        if (paginationNumbers.size() > 0) {
            paginationNumbers.get(0).click();
        }
        throw new RuntimeException("Pagination Number: " + numberPage + " not Found.");
    }

    // Business Logic

}

