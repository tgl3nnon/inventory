package com.glennon.inventory.service.brewery;

import com.glennon.inventory.model.Brewery;

import java.util.Collection;

public interface BreweryService {

    public Collection<Brewery> getAllBreweries();

    public Brewery getBrewery(Brewery Brewery);

    public Brewery addBreweryToInventory(Brewery Brewery);

    public Brewery removeBreweryFromInventory(Brewery Brewery);

    public Brewery updateBreweryInInventory(Brewery Brewery);
}
