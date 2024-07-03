package com.softserve.edu.teachua.pages.user;

import com.softserve.edu.teachua.tools.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;

public class GuestDropdown {

    private WebElement register;
    private WebElement login;
    private final Search search;

    public GuestDropdown() {
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        // TODO AJAX element. Update next
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // init elements
        register = search.cssSelector("li[data-menu-id*='register'] span.ant-dropdown-menu-title-content");
        login = search.cssSelector("li[data-menu-id*='login'] span.ant-dropdown-menu-title-content");
    }

    // Page Object

    // register
    public WebElement getRegister() {
        return register;
    }

    public String getRegisterText() {
        return getRegister().getText();
    }

    public void clickRegister() {
        getRegister().click();
    }

    // login
    public WebElement getLogin() {
        return login;
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public void clickLogin() {
        getLogin().click();
    }

    // Functional

    // Business Logic

    public LoginModal openLoginModal() {
        clickLogin();
        return new LoginModal(DriverManager.getDriver());
    }

}
