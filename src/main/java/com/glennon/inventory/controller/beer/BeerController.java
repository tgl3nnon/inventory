
package com.glennon.inventory.controller.beer;

import com.glennon.inventory.model.Beer;
import com.glennon.inventory.service.beer.BeerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(path = "/beers", produces = MediaType.APPLICATION_JSON_VALUE)
public class BeerController {

    private static final Logger logger = LoggerFactory.getLogger(BeerController.class);

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public Collection<Beer> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping(value = "{beerId}")
    public Beer get(@PathVariable Integer beerId) {
        return beerService.getBeer(beerId);
    }

    @PostMapping(consumes = {"application/json"})
    public Beer create(@RequestBody Beer beer) {
        return beerService.addBeerToInventory(beer);
    }

    @PutMapping(value = "{beerId}", consumes = {"application/json"})
    public Beer update(@RequestBody Beer beer, @PathVariable Integer beerId) {
        beer.setId(beerId);
        return beerService.updateBeerInInventory(beer);
    }

    @DeleteMapping(value = "{beerId}")
    public void remove(@PathVariable Integer beerId) {
        beerService.removeBeerFromInventory(beerId);
    }

    @GetMapping(value = "/brewery/{breweryId}")
    public Collection<Beer> getBeersInBrewery(@PathVariable Integer breweryId) {
        return beerService.getBeersInBrewery(breweryId);
    }

}
