
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
    public Beer getBeer(@PathVariable Integer beerId) {
        return beerService.getBeer(beerId);
    }

//    @RequestMapping(value = "addBeer", method = RequestMethod.POST)
//    public Beer addBeerToInventory(@RequestBody Beer beer) {
//
//        return beerServiceImpl.addBeerToInventory(beer);
//    }
//
//    @RequestMapping(value = "removeBeer", method = RequestMethod.DELETE)
//    public Beer removeBeerToInventory(@RequestBody Beer beer) {
//
//        return beerServiceImpl.removeBeerFromInventory(beer);
//    }
//
//    @RequestMapping(value = "updateBeer", method = RequestMethod.POST)
//    public Beer updateBeerToInventory(@RequestBody Beer beer) {
//
//        return beerServiceImpl.updateBeerInInventory(beer);
//    }

}
