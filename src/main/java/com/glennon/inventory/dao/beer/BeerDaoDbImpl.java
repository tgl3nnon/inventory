package com.glennon.inventory.dao.beer;

import com.glennon.inventory.model.Beer;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BeerDaoDbImpl implements BeerDao {

    @Override
    public Collection<Beer> getAllBeers() {
        return null;
    }

    @Override
    public Beer addBeerToInventory(Beer beer) {
        return null;
    }

    @Override
    public Beer removeBeerFromInventory(Beer beer) {
        return null;
    }

    @Override
    public Beer updateBeerInInventory(Beer beer) {
        return null;
    }

    @Override
    public Beer getBeer(Beer beer) {
        return null;
    }
}
