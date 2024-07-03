package com.softserve.edu.teachua.pages.menu;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.pages.user.LoginModal;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;
public class HomePage extends TopSearchPart {

    public static final String BEGIN_TEACH_LABEL_MESSAGE = "Ініціатива";

    private WebElement addClubButton;
    private WebElement teachLabel;
    private final Search search;

    public HomePage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // init elements
        addClubButton = search.cssSelector("button.add-club-button");
        teachLabel = search.cssSelector("div.city-name-box h2.city-name");
    }

    // Page Object

    // addClubButton
    public WebElement getAddClubButton() {
        return addClubButton;
    }

    public String getAddClubButtonText() {
        return getAddClubButton().getText();
    }

    public void clickAddClubButton() {
        getAddClubButton().click();
    }

    // teachLabel
    public WebElement getTeachLabel() {
        return teachLabel;
    }

    public String getTeachLabelText() {
        return getTeachLabel().getText();
    }

    // Functional

    // Business Logic

    // addClubButton
    public LoginModal openLoginModalAddClub() {
        clickAddClubButton();
        return new LoginModal(DriverManager.getDriver());
    }

}
