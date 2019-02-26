package com.glennon.inventory.dao.brewery;

import com.glennon.inventory.model.Brewery;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BreweryDaoDbImpl implements BreweryDao {

    @Override
    public Collection<Brewery> getAllBreweries() {
        return null;
    }

    @Override
    public Brewery addBreweryToInventory(Brewery brewery) {
        return null;
    }

    @Override
    public void removeBreweryFromInventory(Integer breweryId) {

    }

    @Override
    public Brewery updateBreweryInInventory(Brewery brewery) {
        return null;
    }

    @Override
    public Brewery getBrewery(Integer breweryId) {
        return null;
    }
}
