package com.glennon.inventory.service;

import com.glennon.inventory.model.Beer;

import java.util.Collection;

public interface BeerService {

    public Collection<Beer> getAllBeers();

    public Beer getBeer(Beer beer);

    public Beer addBeerToInventory(Beer beer);

    public Beer removeBeerFromInventory(Beer beer);

    public Beer updateBeerInInventory(Beer beer);
}