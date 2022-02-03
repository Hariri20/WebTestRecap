package com.iman89h.text.strategies;

import com.iman89h.text.ui.PlanetTile;

public class NameMatch implements MatchingStrategy
{
    String name;
    public NameMatch(String name)
    {
        this.name = name;
    }


    @Override
    public boolean match(PlanetTile planet)
    {
        if(planet.getPlanetName().equalsIgnoreCase(name))
        {
            return true;
        }
        return false;
    }
}
