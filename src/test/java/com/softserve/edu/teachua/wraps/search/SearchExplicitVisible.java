package com.softserve.edu.teachua.wraps.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchExplicitVisible extends SearchExplicit {

        @Override
        public WebElement getWebElement(By by) {
            return getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        }

        @Override
        public WebElement getWebElement(By by, WebElement fromWebElement) {
            return getDriverWait().until(ExpectedConditions.visibilityOf(fromWebElement.findElement(by)));
        }

        @Override
        public List<WebElement> getWebElements(By by) {
            return getDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }

        @Override
        public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
            return getDriverWait().until(ExpectedConditions.visibilityOfAllElements(fromWebElement.findElements(by)));
        }
    }
