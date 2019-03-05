package com.glennon.inventory.service.brewery;

import com.glennon.inventory.dao.brewery.BreweryDao;
import com.glennon.inventory.model.Brewery;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BreweryServiceImpl implements  BreweryService{

    private BreweryDao breweryDao;

    public BreweryServiceImpl(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    @Override
    public Collection<Brewery> getAllBreweries() {
        return breweryDao.getAllBreweries();
    }

    @Override
    public Brewery getBrewery(Integer breweryId) {
        return breweryDao.getBrewery(breweryId);
    }

    @Override
    public Brewery addBreweryToInventory(Brewery brewery) {
        return breweryDao.addBreweryToInventory(brewery);
    }

    @Override
    public void removeBreweryFromInventory(Integer breweryId) {
        breweryDao.removeBreweryFromInventory(breweryId);
    }

    @Override
    public Brewery updateBreweryInInventory(Brewery brewery) {
        return breweryDao.updateBreweryInInventory(brewery);
    }
}
