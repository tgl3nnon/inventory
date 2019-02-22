package com.glennon.inventory.service.beer;

import com.glennon.inventory.model.Beer;

import java.util.Collection;

public interface BeerService {

    public Collection<Beer> getAllBeers();

    public Beer getBeer(Beer beer);

    public Beer addBeerToInventory(Beer beer);

    public void removeBeerFromInventory(Beer beer);

    public Beer updateBeerInInventory(Beer beer);
}