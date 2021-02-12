package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;
import static org.apache.commons.io.FileUtils.copyURLToFile;

public class DownloadPage {
    public WebDriver driver;
    public DownloadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"mount\"]/main/div/div[2]/section[2]/div/div[1]/div/div/div/div[1]/span[1]")
    private WebElement linkForDownLoadPage;
    public void clickLinkForDownLoadPage(){
        linkForDownLoadPage.click();
//        ArrayList<String> newTab= new ArrayList <String>(driver.getWindowHandles());
//        driver.switchTo().window(newTab.get(1));
    }

    public void download()  {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount\"]/main/div/div[2]/section[2]/div/div[1]/div/div/div/div[1]")));
        linkForDownLoadPage.click();
    }
}
