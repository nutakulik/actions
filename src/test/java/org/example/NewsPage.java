package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {
    public WebDriver driver;

    public NewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "/html/body/div[2]/header/div/div[1]/div[2]/form/div[1]/span/span/input")
    private WebElement inputSearch;

    @FindBy (xpath = "/html/body/div/div[4]/div/div[1]/div[1]/div")
    private WebElement numbersPageOfSearch;

    @FindBy (xpath = "/html/body/div/div[4]/div/div[1]/div[1]/div/span[1]/a[2]")
    private WebElement secondPageOfSearch;


    public void search() {
        Actions builder =new Actions(driver);
        Action input = builder.moveToElement(inputSearch).click().sendKeys(inputSearch,"covid").sendKeys(Keys.ENTER).build();
        input.perform();

        Action scroll = builder.moveToElement(numbersPageOfSearch).build();
        scroll.perform();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[4]/div/div[1]/div[1]/div/span[1]/a[2]")));

        secondPageOfSearch.click();

    }

    public void searchJS(){
        inputSearch.click();
        inputSearch.sendKeys(ConfProperties.getProperty("search"));
        inputSearch.sendKeys(Keys.ENTER);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", numbersPageOfSearch);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[4]/div/div[1]/div[1]/div/span[1]/a[2]")));

        secondPageOfSearch.click();
    }
}
