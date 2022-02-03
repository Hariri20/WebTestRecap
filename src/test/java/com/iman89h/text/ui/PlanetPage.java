package com.iman89h.text.ui;

import com.iman89h.text.strategies.MatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanetPage
{
    private WebDriver driver;

    public PlanetPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public PlanetTile getPlanetByName(String planetName)
    {
        PlanetTile foundPlanet = null;
        var planets = driver.findElements(By.cssSelector(".planet"));

        for(WebElement planet : planets)
        {
            PlanetTile currentPlanet = new PlanetTile(planet);
           if(currentPlanet.getPlanetName().equalsIgnoreCase(planetName))
           {
               foundPlanet = currentPlanet;
               break;
           }
        }

        if(foundPlanet == null){throw new NotFoundException("Planet not found");}
        return foundPlanet;
    }

    public PlanetTile getPlanetTile(MatchingStrategy strategy)
    {
        var planetTiles = driver.findElements(By.cssSelector(".planet"));
        for(WebElement tile : planetTiles)
        {
            PlanetTile planet = new PlanetTile(tile);
            if(strategy.match(planet))
            {
                return planet;
            }
        }
        throw new NotFoundException("Planet not found!");
    }

    public boolean isPopUpVisible()
    {
        return driver.findElement(By.cssSelector(".snackbar")).isDisplayed();
    }

    public String getExploreMessage()
    {
        return driver.findElement(By.cssSelector(".snackbar")).getText();
    }

    public PlanetTile getFurthestPlanet()
    {
        PlanetTile furthestPlanet = null;
        var planets = driver.findElements(By.cssSelector(".planet"));
        long furthestDistance = 0;

        for(WebElement planet : planets)
        {
            var currentPlanet = new PlanetTile(planet);
            if(currentPlanet.getIntegerPlanetDistance() > furthestDistance)
            {
                furthestPlanet = currentPlanet;
                furthestDistance = currentPlanet.getIntegerPlanetDistance();
            }
        }
        if(furthestPlanet == null){throw (new NotFoundException());}
        return furthestPlanet;
    }


}
