
package com.glennon.inventory.service.beer;

import com.glennon.inventory.dao.beer.BeerDao;
import com.glennon.inventory.model.Beer;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BeerServiceImpl implements BeerService {

    private BeerDao beerDao;

    public BeerServiceImpl(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    public Collection<Beer> getAllBeers() {

        return beerDao.getAllBeers();
    }

    public Beer getBeer(Integer beerId) {

        return beerDao.getBeer(beerId);
    }

    public Beer addBeerToInventory(Beer beer) {
        return beerDao.addBeerToInventory(beer);
    }

    public void removeBeerFromInventory(Integer beerId) {

        beerDao.removeBeerFromInventory(beerId);
    }

    public Beer updateBeerInInventory(Beer beer) {

        return beerDao.updateBeerInInventory(beer);
    }

    @Override
    public Collection<Beer> getBeersInBrewery(Integer breweryId) {
        return beerDao.getBeersInBrewery(breweryId);
    }
}
