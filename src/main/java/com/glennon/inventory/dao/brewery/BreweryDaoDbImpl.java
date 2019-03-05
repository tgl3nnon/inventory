package com.glennon.inventory.dao.brewery;

import com.glennon.inventory.model.Brewery;
import com.glennon.inventory.repository.BreweryRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BreweryDaoDbImpl implements BreweryDao {

    private BreweryRepository breweryRepository;

    public BreweryDaoDbImpl(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    @Override
    public Collection<Brewery> getAllBreweries() {
        return breweryRepository.findAll();
    }

    @Override
    public Brewery addBreweryToInventory(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    @Override
    public void removeBreweryFromInventory(Integer breweryId) {
        breweryRepository.delete(breweryId);
    }

    @Override
    public Brewery updateBreweryInInventory(Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    @Override
    public Brewery getBrewery(Integer breweryId) {
        return breweryRepository.getOne(breweryId);
    }
}
