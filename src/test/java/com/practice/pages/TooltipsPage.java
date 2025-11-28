package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TooltipsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    // ✅ Your actual button locators
    private By tooltipTop = By.id("btn1");
    private By tooltipEnd = By.id("btn2");
    private By tooltipBottom = By.id("btn3");
    private By tooltipStart = By.id("btn4");
    private By tooltipHtml = By.id("btn5");

    // ✅ Bootstrap tooltip container
    private By tooltipBox = By.cssSelector("div.tooltip.show div.tooltip-inner");

    public TooltipsPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    // ✅ Generic reusable hover method
    private String hoverAndGetText(By locator) {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Move mouse to trigger tooltip
        actions.moveToElement(element).perform();

        // ✅ Always re-locate tooltip AFTER hover (prevents stale reference)
        By tooltipBox = By.cssSelector("div.tooltip.show div.tooltip-inner");

        WebElement tooltip = wait.until(ExpectedConditions.presenceOfElementLocated(tooltipBox));
        wait.until(ExpectedConditions.visibilityOf(tooltip));

        return tooltip.getText().trim();
    }
    public String getTopTooltipText() {
        return hoverAndGetText(tooltipTop);
    }

    public String getEndTooltipText() {
        return hoverAndGetText(tooltipEnd);
    }

    public String getBottomTooltipText() {
        return hoverAndGetText(tooltipBottom);
    }

    public String getStartTooltipText() {
        return hoverAndGetText(tooltipStart);
    }

    public String getHtmlTooltipText() {
        return hoverAndGetText(tooltipHtml);
    }
}
