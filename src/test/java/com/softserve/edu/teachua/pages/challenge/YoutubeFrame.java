package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopPart;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeFrame {

    private WebDriver driver;
    //
    private WebElement videoPlayerLink;
    private WebElement videoPlayButton;
    private WebElement youtubeLink;

    public YoutubeFrame(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        videoPlayerLink = driver.findElement(By.cssSelector("div.html5-video-player"));
        videoPlayButton = driver.findElement(By.cssSelector("button[aria-label='Play']"));
        youtubeLink = driver.findElement(By.cssSelector("a[title='Watch on YouTube']"));
    }

    // Page Object

    // videoPlayerLink
    public WebElement getVideoPlayerLink() {
        return videoPlayerLink;
    }

    public void clickVideoPlayerLink() {
        getVideoPlayerLink().click();
    }

    // videoPlayButton
    public WebElement getVideoPlayButton() {
        return videoPlayButton;
    }

    public void clickVideoPlayButton() {
        getVideoPlayButton().sendKeys(Keys.ENTER);
        //getVideoPlayButton().click();
    }

    // youtubeLink
    public WebElement getYoutubeLink() {
        return youtubeLink;
    }

    public String getYoutubeLinkText() {
        return getYoutubeLink().getAttribute(TopPart.TAG_ATTRIBUTE_HREF);
    }

    public void clickYoutubeLink() {
        getYoutubeLink().click();
    }

    // Functional

    // Business Logic

    public YoutubeFrame playVideoContent() {
        clickVideoPlayButton();
        //clickVideoPlayButton();
        return this;
    }

    public ChallengeTeachPage gotoChallengeTeachPage() {
        // Return to ChallengeTeachPage
        driver.switchTo().defaultContent();
        return new ChallengeTeachPage(driver);
    }

}
