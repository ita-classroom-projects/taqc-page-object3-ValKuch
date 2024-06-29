package com.softserve.edu.teachua.pages.club;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CommentsContainer {

    public final String COMMENT_NOT_FOUND = "There is no comments that matches the search criteria.";
    private final String COMMENT_COMPONENT_CSSSELECTOR = "li div.ant-comment";
    //
    protected WebDriver driver;
    //
    private List<CommentComponent> commentComponents;
    private WebElement showMoreButton;

    public CommentsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        commentComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(COMMENT_COMPONENT_CSSSELECTOR))) {
            commentComponents.add(new CommentComponent(driver, current));
        }
        if (getCommentComponents().size() > 0) {
            showMoreButton = driver.findElement(By.cssSelector("button.show-more-button"));
        }
    }

    // Page Object

    // commentComponents
    public List<CommentComponent> getCommentComponents() {
        return commentComponents;
    }

    // showMoreButton
    public WebElement getShowMoreButton() {
        if (showMoreButton == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException(COMMENT_NOT_FOUND);
        }
        return showMoreButton;
    }

    public String getShowMoreButtonText() {
        return getShowMoreButton().getText();
    }

    public void clickShowMoreButton() {
        getShowMoreButton().click();
    }

    // Functional

    public int getCommentComponentsCount() {
        return getCommentComponents().size();
    }

    public List<String> getClubComponentAuthors() {
        List<String> clubComponentAuthors = new ArrayList<>();
        for (CommentComponent current : getCommentComponents()) {
            clubComponentAuthors.add(current.getAuthorLabelText());
        }
        return clubComponentAuthors;
    }

    public List<String> getClubComponentComments() {
        List<String> clubComponentComments = new ArrayList<>();
        for (CommentComponent current : getCommentComponents()) {
            clubComponentComments.add(current.getDatetimeLabelText());
        }
        return clubComponentComments;
    }

    public CommentComponent getFirstCommentComponent() {
        if (getCommentComponentsCount() == 0) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException(COMMENT_NOT_FOUND);
        }
        return  getCommentComponents().get(0);
    }

    public CommentComponent getClubComponentByPartialAuthor(String partialAuthor) {
        CommentComponent result = null;
        for (CommentComponent current : getCommentComponents()) {
            if (current.getAuthorLabelText().toLowerCase()
                    .contains(partialAuthor.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("Comment partialAuthor: " + partialAuthor + " not Found.");
        }
        return result;
    }

    public CommentComponent getClubComponentByDateTime(String dateTime) {
        CommentComponent result = null;
        for (CommentComponent current : getCommentComponents()) {
            if (current.getDatetimeLabelText().toLowerCase()
                    .equals(dateTime.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("Comment dateTime: " + dateTime + " not Found.");
        }
        return result;
    }

    public CommentComponent getClubComponentByPartialDate(String partialDate) {
        CommentComponent result = null;
        for (CommentComponent current : getCommentComponents()) {
            if (current.getDatetimeLabelText().toLowerCase()
                    .contains(partialDate.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            throw new RuntimeException("Comment partialDate: " + partialDate + " not Found.");
        }
        return result;
    }

    public boolean isExistClubComponentByPartialAuthor(String partialAuthor) {
        boolean isFound = false;
        for (String current : getClubComponentAuthors()) {
            if (current.toLowerCase().contains(partialAuthor.toLowerCase())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    // Business Logic

}
