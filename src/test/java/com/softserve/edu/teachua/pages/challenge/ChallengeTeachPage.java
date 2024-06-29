package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengeTeachPage extends ChallengePage {

    private WebElement commentLabel;
    private WebElement webinarIframe;

    public ChallengeTeachPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        commentLabel = driver.findElement(By.xpath("//p[contains(text(), 'Вуйтік')]"));
        webinarIframe = driver.findElement(By.xpath("//iframe[contains(@src, '/JMAF_pSOBws')]"));
    }

    // Page Object

    // commentLabel
    public WebElement getCommentLabel() {
        return commentLabel;
    }

    public String getCommentLabelText() {
        return getCommentLabel().getText();
    }

    // webinarIframe
    public WebElement getWebinarIframe() {
        return webinarIframe;
    }

    public void clickWebinarIframe() {
        getWebinarIframe().click();
    }

    // Functional

    // Business Logic

    public YoutubeFrame gotoYoutubeFrame() {
        // clickWebinarIframe();
        driver.switchTo().frame(getWebinarIframe());
        return new YoutubeFrame(driver);
    }

}
