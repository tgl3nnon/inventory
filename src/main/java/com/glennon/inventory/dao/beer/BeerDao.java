
package com.glennon.inventory.dao.beer;

import com.glennon.inventory.model.Beer;

import java.util.Collection;

public interface BeerDao {

    Collection<Beer> getAllBeers();

    Beer addBeerToInventory(Beer beer);

    Beer removeBeerFromInventory(Beer beer);

    Beer updateBeerInInventory(Beer beer);

    Beer getBeer(Beer beer);

}