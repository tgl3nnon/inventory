package com.glennon.inventory.dao.beer;

import com.glennon.inventory.model.Beer;
import com.glennon.inventory.repository.BeerRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BeerDaoDbImpl implements BeerDao {

    private BeerRepository beerRepository;

    public BeerDaoDbImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public Collection<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    public Beer addBeerToInventory(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public void removeBeerFromInventory(Integer beerId) {
        beerRepository.delete(beerId);
    }

    @Override
    public Beer updateBeerInInventory(Beer beer) {
        beerRepository.getOne(beer.getId());
        return beerRepository.save(beer);
    }

    @Override
    public Beer getBeer(Integer beerId) {
        return beerRepository.getOne(beerId);
    }
}
