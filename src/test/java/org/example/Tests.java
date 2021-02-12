package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class Tests {
    public static WebDriver driver;
    public static StartPage startPage;
    public static NewsPage newsPage;
    public static DownloadPage downloadPage;

    @BeforeMethod
    public static void setup(){
        if(driver==null) {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", "C:\\Users\\panas");
            prefs.put("useAutomationExtension", false);
            prefs.put("excludeSwitches", Collections.singletonList("enable-automation"));
            prefs.put("disable-popup-blocking", "true");
            options.setExperimentalOption("prefs", prefs);
//            options.setExperimentalOption("useAutomationExtension", false);
//            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

//            options.setExperimentalOption("disable-popup-blocking", "true");
            //options.setHeadless(true);
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.get(ConfProperties.getProperty("page"));
        }
        startPage = new StartPage(driver);
        newsPage = new NewsPage(driver);
        downloadPage = new DownloadPage(driver);
    }

//    @AfterMethod
//    public static void end(){
//        driver.close();
//        ArrayList<String> newTab= new ArrayList <String>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(0));
//    }
//
//    @AfterTest
//    public static void endAll(){
//        driver.quit();
//    }

    @Test
    public void actionTest() {
        startPage.clickNews();
        newsPage.search();
    }

    @Test
    public void jsTest() {
        startPage.clickNewsJS();
        newsPage.searchJS();
    }

    @Test
    public void download() throws IOException {
       startPage.clickLinkForDownLoadPage();
       downloadPage.download();
    }

}
