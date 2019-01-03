
package com.glennon.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/")
public class BeerController {

    private static final Logger logger = LoggerFactory.getLogger(BeerController.class);

//    @Autowired
//    private BeerServiceImpl beerServiceImpl;
//
//    @RequestMapping(value = "beers", method = RequestMethod.GET)
//    public Collection<Beer> getAllBeers() {
//
//        return beerServiceImpl.getAllBeers();
//    }
//
//    @RequestMapping(value = "getBeer", method = RequestMethod.POST)
//    public Beer getBeer(@RequestBody Beer beer) {
//
//        return beerServiceImpl.getBeer(beer);
//    }
//
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
