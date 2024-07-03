package com.softserve.edu.teachua.tests;

import com.softserve.edu.teachua.pages.menu.HomePage;
import com.softserve.edu.teachua.tools.DriverManager;
import com.softserve.edu.teachua.tools.PropertiesUtils;
import com.softserve.edu.teachua.wraps.browser.DriverUtils;
import com.softserve.edu.teachua.wraps.browser.UrlUtils;
import com.softserve.edu.teachua.wraps.search.SearchStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@ExtendWith(RunnerExtension.class)
public abstract class TestRunner {

    private static final Long ONE_SECOND_DELAY = 1000L;
    protected static boolean isTestSuccessful = false;

    // Overload
    protected static void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    protected static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void beforeAll() {
    }

    @AfterAll
    public static void afterAll() {
        presentationSleep(); // For Presentation ONLY
        DriverUtils.quit();
    }

    public void beforeEach() {
        WebDriver driver = DriverUtils.addDriverByPartialName(PropertiesUtils.get().readBrowserName());
        DriverManager.setDriver(driver);
        presentationSleep(); // For Presentation ONLY
    }


    @AfterEach
    public void afterEach(TestInfo testInfo) {
        if (!isTestSuccessful) {
            System.out.println("\t\t\tTest_Name = " + testInfo.getDisplayName() + " fail");
            System.out.println("\t\t\tTest_Method = " + testInfo.getTestMethod() + " fail");
            DriverUtils.takeScreenShot();
            DriverUtils.takePageSource();
        }
        DriverUtils.deleteCookies();
        DriverUtils.deleteTokens();
        DriverUtils.quit();
        presentationSleep(); // For Presentation ONLY
    }


    protected HomePage loadApplication() {
        WebDriver driver = DriverUtils.getDriver();
        driver.get(UrlUtils.getBaseUrl());
        return new HomePage();
    }
}
