
package com.glennon.inventory.controller.brewery;

import com.glennon.inventory.model.Brewery;
import com.glennon.inventory.service.brewery.BreweryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(path = "/breweries", produces = MediaType.APPLICATION_JSON_VALUE)
public class BreweryController {

    private static final Logger logger = LoggerFactory.getLogger(BreweryController.class);

    private BreweryService breweryService;

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping
    public Collection<Brewery> getAllbreweries() {
        return breweryService.getAllBreweries();
    }

    @GetMapping(value = "{breweryId}")
    public Brewery get(@PathVariable Integer breweryId) {
        return breweryService.getBrewery(breweryId);
    }

    @PostMapping(consumes = {"application/json"})
    public Brewery create(@RequestBody Brewery brewery) {
        return breweryService.addBreweryToInventory(brewery);
    }

    @PutMapping(value = "{breweryId}", consumes = {"application/json"})
    public Brewery update(@RequestBody Brewery brewery, @PathVariable Integer breweryId) {
        brewery.setId(breweryId);
        return breweryService.updateBreweryInInventory(brewery);
    }

    @DeleteMapping(value = "{breweryId}")
    public void remove(@PathVariable Integer breweryId) {
        breweryService.removeBreweryFromInventory(breweryId);
    }

    //TODO get all beers for a brewery

}
