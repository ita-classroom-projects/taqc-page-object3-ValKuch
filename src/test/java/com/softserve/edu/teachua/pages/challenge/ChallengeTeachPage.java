package com.softserve.edu.teachua.pages.challenge;

import com.softserve.edu.teachua.pages.top.TopSearchPart;
import com.softserve.edu.teachua.tools.DriverManager;
import com.softserve.edu.teachua.wraps.search.Search;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;
import org.openqa.selenium.WebElement;

public class ChallengeTeachPage extends TopSearchPart {

    private WebElement commentLabel;
    private WebElement webinarIframe;
    private final Search search;

    public ChallengeTeachPage() {
        super(DriverManager.getDriver());
        this.search = SearchStrategy.getSearch();
        initElements();
    }

    private void initElements() {
        commentLabel = search.xpath("//p[contains(text(), 'Вуйтік')]");
        webinarIframe = search.xpath("//iframe[contains(@src, '/JMAF_pSOBws')]");
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
        DriverManager.getDriver().switchTo().frame(getWebinarIframe());
        return new YoutubeFrame();
    }

}
