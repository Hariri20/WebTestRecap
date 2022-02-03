package com.iman89h.text.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetTile
{
    protected WebElement element;

    public PlanetTile(WebElement element)
    {
        this.element = element;
    }

    public String getPlanetName()
    {
        return element.findElement(By.tagName("h2")).getText();
    }

    public String getPlanetDistance()
    {
        return element.findElement(By.cssSelector(".distance")).getText();
    }

    public Long getIntegerPlanetDistance()
    {
        String distance = element.findElement(By.cssSelector(".distance")).getText();
        String[] distanceText = distance.split("k");
        Long intDistance = Long.parseLong(distanceText[0].replace(",","").trim());
        return intDistance;
    }

    public void ClickExploreButton()
    {
        element.findElement(By.tagName("button")).click();
    }

}
