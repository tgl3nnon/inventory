package com.glennon.inventory.service.beer;

import com.glennon.inventory.model.Beer;

import java.util.Collection;

public interface BeerService {

    public Collection<Beer> getAllBeers();

    public Beer getBeer(Integer beerId);

    public Beer addBeerToInventory(Beer beer);

    public void removeBeerFromInventory(Integer beerId);

    public Beer updateBeerInInventory(Beer beer);
}