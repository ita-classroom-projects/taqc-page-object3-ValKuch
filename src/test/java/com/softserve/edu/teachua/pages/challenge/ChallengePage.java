package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ChallengePage extends TopSearchPart {

    private WebElement bannerLabel;

    public ChallengePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        bannerLabel = driver.findElement(By.cssSelector("div.banner span.title"));
    }

    // Page Object

    // bannerLabel
    public WebElement getBannerLabel() {
        return bannerLabel;
    }

    public String getBannerLabelText() {
        return getBannerLabel().getText();
    }

    // Functional

    // Business Logic

}
