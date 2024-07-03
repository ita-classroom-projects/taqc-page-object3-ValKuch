package com.softserve.edu.teachua.pages.user;

import com.softserve.edu.teachua.pages.menu.HomePage;
import com.softserve.edu.teachua.pages.top.TopPart;
import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;


import java.time.Duration;

public class LoginModal {

    public static final String POPUP_MESSAGE_UNSUCCESSFULLY = "Введено невірний пароль або email";

    // private WebDriver driver; // Removed
    //
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement signInButton;
    private final Search search;

    public LoginModal(WebDriver driver) {
        // this.driver = driver; // Removed
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        emailInput = search.id("basic_email");
        passwordInput = search.id("basic_password");
        signInButton = search.cssSelector("div.login-footer button");
    }

    // Page Object

    // emailInput
    public WebElement getEmailInput() {
        return emailInput;
    }

    public String getEmailInputText() {
        return getEmailInput().getAttribute("value");
    }

    public void clearEmailInput() {
        getEmailInput().clear();
    }

    public void clickEmailInput() {
        getEmailInput().click();
    }

    public void setEmailInput(String email) {
        getEmailInput().sendKeys(email);
    }

    // passwordInput
    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public String getPasswordInputText() {
        return getPasswordInput().getAttribute("value");
    }

    public void clearPasswordInput() {
        getPasswordInput().clear();
    }

    public void clickPasswordInput() {
        getPasswordInput().click();
    }

    public void setPasswordInput(String password) {
        getPasswordInput().sendKeys(password);
    }

    // signInButton
    public WebElement getSignInButton() {
        return signInButton;
    }

    public String getSignInButtonText() {
        return getSignInButton().getAttribute("value");
    }

    public void clickSignInButton() {
        getSignInButton().click();
    }

    // Functional

    private void enterEmailInput(String email) {
        clickEmailInput();
        clearEmailInput();
        setEmailInput(email);
    }

    private void enterPasswordInput(String password) {
        clickPasswordInput();
        clearPasswordInput();
        setPasswordInput(password);
    }

    public void fillLogin(String email, String password) {
        enterEmailInput(email);
        enterPasswordInput(password);
        clickSignInButton();
    }

    // popupMessageLabel
    public String getPopupMessageLabelText() {
        WebDriver driver = null;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TopPart.POPUP_MESSAGE_CSSSELECTOR)));
        WebElement popupMessageLabel = driver.findElement(By.cssSelector(TopPart.POPUP_MESSAGE_CSSSELECTOR));
        return popupMessageLabel.getText();
    }

    // Business Logic

    public HomePage successfulLogin(String email, String password) {
        fillLogin(email, password);
        return new HomePage();
    }

    public LoginModal unsuccessfulLoginPage(String email, String password) {
        fillLogin(email, password);
        return new LoginModal(DriverManager.getDriver());
    }
}
