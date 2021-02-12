package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class StartPage {
    public WebDriver driver;
    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[3]/div/div[2]/div/div/div[2]/a[3]")
    private WebElement newsButton;

    public void clickNews(){
        newsButton.click();
        ArrayList<String> newTab= new ArrayList <String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

    }
    public void clickNewsJS(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", newsButton);
        ArrayList<String> newTab= new ArrayList <String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

    }

    @FindBy (css = "body > div.rows-wrapper > div.OG.rows > div.un.rows__row.rows__row_main > div > fgn > dbgrsae > ftgr > edvrt > edvrt > edvrt:nth-child(4) > eflll > div > fwap > pjtr > div > div > div.Iz__Cf > div > span > a.home-link.yabrowser-promo__icon-link.home-link_black_yes")
    private WebElement linkForDownLoadPage;
    public void clickLinkForDownLoadPage(){
        Actions builder =new Actions(driver);
        Action input = builder.moveByOffset(1100,358).click().build();
        input.perform();
        ArrayList<String> newTab= new ArrayList <String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
    }

}
