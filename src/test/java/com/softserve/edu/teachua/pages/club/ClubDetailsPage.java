package com.softserve.edu.teachua.pages.club;

import com.softserve.edu.teachua.pages.top.TopPart;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

import static com.softserve.edu.teachua.tools.DriverManager.getDriver;

public class ClubDetailsPage extends TopPart {

    private CommentsContainer commentsContainer;
    private WebElement createCommentButton;
    private final Search search;

    public ClubDetailsPage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // Initialize elements here
        commentsContainer = new CommentsContainer(DriverManager.getDriver());
        createCommentButton = search.cssSelector("button.comment-button");
    }

    // Page Object

    public CommentsContainer getCommentsContainer() {
        return commentsContainer;
    }

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
        return new ClubCommentModal(getDriver());
    }

    // Overridden methods from TopPart can be left unchanged
}

