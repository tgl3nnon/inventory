package com.glennon.inventory.dao.brewery;

import com.glennon.inventory.model.Brewery;

import java.util.Collection;

public interface BreweryDao {

    Collection<Brewery> getAllBreweries();

    Brewery addBreweryToInventory(Brewery brewery);

    void removeBreweryFromInventory(Integer breweryId);

    Brewery updateBreweryInInventory(Brewery brewery);

    Brewery getBrewery(Integer breweryId);
}