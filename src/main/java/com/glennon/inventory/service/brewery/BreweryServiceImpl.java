package com.glennon.inventory.service.brewery;

import com.glennon.inventory.model.Brewery;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BreweryServiceImpl implements  BreweryService{

    @Override
    public Collection<Brewery> getAllBreweries() {
        return null;
    }

    @Override
    public Brewery getBrewery(Integer breweryId) {
        return null;
    }

    @Override
    public Brewery addBreweryToInventory(Brewery Brewery) {
        return null;
    }

    @Override
    public void removeBreweryFromInventory(Integer breweryId) {

    }

    @Override
    public Brewery updateBreweryInInventory(Brewery Brewery) {
        return null;
    }
}
