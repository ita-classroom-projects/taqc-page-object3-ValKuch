package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubDetailsPage extends TopPart {

    private CommentsContainer commentsContainer;
    //
    private WebElement createCommentButton;
    //
    //private WebElement authorContentLabel;
    //private WebElement datetimeLabel;
    //private WebElement commentContentLabel;

    public ClubDetailsPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        commentsContainer = new CommentsContainer(driver);
        createCommentButton = driver.findElement(By.cssSelector("button.comment-button"));
        //
        //authorContentLabel = driver.findElement(By.cssSelector("div.ant-spin-container li:first-child div.author-content > span.name"));
        //datetimeLabel = driver.findElement(By.cssSelector("div.ant-spin-container li:first-child div.author-content > span.datetime"));
        //commentContentLabel = driver.findElement(By.cssSelector("div.ant-spin-container li:first-child div.ant-comment-content-detail > p"));
    }

    // Page Object

    // commentsContainer
    public CommentsContainer getCommentsContainer() {
        return commentsContainer;
    }

    // createCommentButton
    public WebElement getCreateCommentButton() {
        return createCommentButton;
    }

    public String getCreateCommentButtonText() {
        return getCreateCommentButton().getText();
    }

    public void clickCreateCommentButton() {
        getCreateCommentButton().click();
    }

    // Functional

    // Business Logic

    public ClubCommentModal openClubCommentModal() {
        clickCreateCommentButton();
        return new ClubCommentModal(driver);
    }

}
