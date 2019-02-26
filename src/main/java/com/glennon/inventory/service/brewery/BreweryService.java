package com.glennon.inventory.service.brewery;

import com.glennon.inventory.model.Brewery;

import java.util.Collection;

public interface BreweryService {

    public Collection<Brewery> getAllBreweries();

    public Brewery getBrewery(Integer breweryId);

    public Brewery addBreweryToInventory(Brewery Brewery);

    public void removeBreweryFromInventory(Integer breweryId);

    public Brewery updateBreweryInInventory(Brewery Brewery);
}
