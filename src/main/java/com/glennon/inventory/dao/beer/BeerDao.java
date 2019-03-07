package com.glennon.inventory.dao.beer;

import com.glennon.inventory.model.Beer;

import java.util.Collection;

public interface BeerDao {

    Collection<Beer> getAllBeers();

    Beer addBeerToInventory(Beer beer);

    void removeBeerFromInventory(Integer beerId);

    Beer updateBeerInInventory(Beer beer);

    Beer getBeer(Integer beerId);

    Collection<Beer> getBeersInBrewery(Integer breweryId);
}