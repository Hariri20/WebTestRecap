package com.iman89h.text.WebTestSuit;

import com.iman89h.text.strategies.DistanceMatch;
import com.iman89h.text.strategies.NameMatch;
import com.iman89h.text.ui.Menu;
import com.iman89h.text.ui.PlanetPage;
import com.iman89h.text.ui.PlanetTile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlanetTest extends BaseTest
{
    protected Menu menu;



    @Test
    public void GetJupiterDistance()
    {
        menu = new Menu(driver);
        menu.clickPlanet();

        var planetPage = new PlanetPage(driver);

        var jupiter = planetPage.getPlanetByName("Jupiter");

        Assertions.assertEquals("778,500,000 km", jupiter.getPlanetDistance());
        Assertions.assertEquals(778500000, jupiter.getIntegerPlanetDistance());
    }

    @Test
    public void NameAndDistanceMatchTest()
    {
        //Arrange
        menu = new Menu(driver);
        menu.clickPlanet();
        var planetPage = new PlanetPage(driver);

        //Act
        PlanetTile planet = planetPage.getPlanetTile(new NameMatch("Jupiter"));

        //Assert
        Assertions.assertEquals(778500000,planet.getIntegerPlanetDistance());
        Assertions.assertEquals("Jupiter", planet.getPlanetName());
    }

    @Test
    public void ExploreMessageTest()
    {
        //Arrange
        menu = new Menu(driver);
        menu.clickPlanet();
        var planetPage = new PlanetPage(driver);

        //Act
        PlanetTile planet = planetPage.getPlanetTile(new DistanceMatch(108_200_000));
        planet.ClickExploreButton();
        String planetName = planet.getPlanetName();
        String expected = "Exploring " + planetName;
        new WebDriverWait(driver,5).until(driver1 -> planetPage.isPopUpVisible());

        //Assert
        Assertions.assertEquals(expected, planetPage.getExploreMessage());


    }

    @Test
    public void FindingTheFurthest()
    {
        //Arrange
        menu = new Menu(driver);
        menu.clickPlanet();
        var planetPage = new PlanetPage(driver);

        //Act
        PlanetTile planet = planetPage.getFurthestPlanet();

        //Assert
        Assertions.assertEquals("Uranus", planet.getPlanetName());
        System.out.println(planet.getPlanetName());
        System.out.println(planet.getIntegerPlanetDistance());


    }


}
