package com.softserve.edu.teachua.wraps.search;

import java.util.List;

import com.softserve.edu.teachua.tools.PropertiesUtils;
import com.softserve.edu.teachua.wraps.browser.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchImplicit extends Search {
    private final long DEFAULT_IMPLICIT_WAIT_SECONDS = 10L;

    public SearchImplicit() {
        initImplicit();
    }

    private void initImplicit() {
        long propertyWaitSeconds = DEFAULT_IMPLICIT_WAIT_SECONDS;
        String propertyWait = PropertiesUtils.get().readImplicitWait();
        try {
            propertyWaitSeconds = Long.valueOf(propertyWait);
        } catch (NumberFormatException e) {
            // log
            // TODO Develop Custom Exception
            System.out.println("ERROR Reading Implicitly properties. Use default: " + DEFAULT_IMPLICIT_WAIT_SECONDS + "  Message = " + e.getMessage());
            //throw new RuntimeException(e);
        }
        DriverUtils.setImplicitWait(propertyWaitSeconds);
        System.out.println("\tUsing SearchImplicit");
    }

    @Override
    public WebElement getWebElement(By by) {
        return DriverUtils.getDriver().findElement(by);
    }

    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        return fromWebElement.findElement(by);
    }

    @Override
    public List<WebElement> getWebElements(By by) {
        return DriverUtils.getDriver().findElements(by);
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        return fromWebElement.findElements(by);
    }

}
