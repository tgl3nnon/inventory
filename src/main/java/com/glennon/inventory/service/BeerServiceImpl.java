
package com.glennon.inventory.service;

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

    public Beer getBeer(Beer beer) {

        return beerDao.getBeer(beer);
    }

    public Beer addBeerToInventory(Beer beer) {

        return beerDao.addBeerToInventory(beer);
    }

    public Beer removeBeerFromInventory(Beer beer) {

        return beerDao.removeBeerFromInventory(beer);
    }

    public Beer updateBeerInInventory(Beer beer) {

        return beerDao.updateBeerInInventory(beer);
    }

}
