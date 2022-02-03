package com.iman89h.text.strategies;

import com.iman89h.text.ui.PlanetTile;

public class DistanceMatch implements MatchingStrategy
{
    long distance;
    public DistanceMatch(long distance)
    {
        this.distance = distance;
    }

    @Override
    public boolean match(PlanetTile planet)
    {
        if(planet.getIntegerPlanetDistance() == distance)
        {
            return true;
        }
        return false;
    }

}
