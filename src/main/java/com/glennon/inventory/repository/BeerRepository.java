package com.glennon.inventory.repository;

import com.glennon.inventory.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface BeerRepository extends JpaRepository<Beer, Integer> {

    @Query(value = "SELECT B FROM Beer B WHERE B.brewery.id = ?1")
    Collection<Beer> getBeersInBrewery(Integer breweryId);
}
