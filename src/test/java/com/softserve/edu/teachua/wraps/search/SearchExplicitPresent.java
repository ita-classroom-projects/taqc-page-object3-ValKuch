package com.softserve.edu.teachua.wraps.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchExplicitPresent extends SearchExplicit {

    @Override
    public WebElement getWebElement(By by) {
        return getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        return getDriverWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(fromWebElement, by));
    }

    @Override
    public List<WebElement> getWebElements(By by) {
        return getDriverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        return getDriverWait().until(ExpectedConditions.presenceOfNestedElementsLocatedBy((By) fromWebElement, by));
    }
}