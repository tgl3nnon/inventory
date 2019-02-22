package com.glennon.inventory.repository;

import com.glennon.inventory.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Integer> {
}
