package com.practice.tests;

import com.practice.base.BaseTest;
import com.practice.pages.TooltipsPage;
import com.practice.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.practice.tests.ScreenshotListener.class)
public class TooltipsTest extends BaseTest {

    @Test
    public void verifyAllTooltips() {

        TooltipsPage tooltips = new TooltipsPage(driver, wait, actions);

        String top    = tooltips.getTopTooltipText();
        String end    = tooltips.getEndTooltipText();
        String bottom = tooltips.getBottomTooltipText();
        String start  = tooltips.getStartTooltipText();
        String html   = tooltips.getHtmlTooltipText();

        System.out.println("Top Tooltip: " + top);
        System.out.println("End Tooltip: " + end);
        System.out.println("Bottom Tooltip: " + bottom);
        System.out.println("Start Tooltip: " + start);
        System.out.println("HTML Tooltip: " + html);

        // Assuming tooltip text matches button text (which your console output shows)
        Assert.assertEquals(top,    "Tooltip on top");
        Assert.assertEquals(end,    "Tooltip on end");
        Assert.assertEquals(bottom, "Tooltip on bottom");
        Assert.assertEquals(start,  "Tooltip on start");

        // For HTML tooltip you can check partial text if it’s rich HTML
        Assert.assertTrue(html.contains("Tooltip"), "HTML tooltip text should contain 'Tooltip'");
    }

    // Optional: keep this if you want a screenshot even when test passes
    @Test
    public void manualScreenshotExample() {
        TooltipsPage tooltips = new TooltipsPage(driver, wait, actions);
        String bottom = tooltips.getBottomTooltipText();
        System.out.println("Bottom Tooltip: " + bottom);

        ScreenshotUtil.takeScreenshot(driver, "manualScreenshotExample");
    }
}
