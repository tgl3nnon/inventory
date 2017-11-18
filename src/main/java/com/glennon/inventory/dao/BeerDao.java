
package com.glennon.inventory.dao;

import java.util.Collection;

import com.glennon.inventory.model.Beer;

public interface BeerDao {

	Collection<Beer> getAllBeers();

	Beer addBeerToInventory(Beer beer);

	Beer removeBeerFromInventory(Beer beer);
	
	Beer updateBeerInInventory(Beer beer);
	
	Beer getBeer(Beer beer);

}