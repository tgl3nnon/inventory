
package com.glennon.inventory.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glennon.inventory.model.Beer;
import com.glennon.inventory.service.BeerService;

@RestController
@RequestMapping("/")
public class BeerController {

	@Autowired
	private BeerService beerService;

	@RequestMapping(value = "beers", method = RequestMethod.GET)
	public Collection<Beer> getAllBeers() {

		return beerService.getAllBeers();
	}

	@RequestMapping(value = "getBeer", method = RequestMethod.POST)
	public Beer getBeer(@RequestBody Beer beer) {

		return beerService.getBeer(beer);
	}

	@RequestMapping(value = "addBeer", method = RequestMethod.POST)
	public Beer addBeerToInventory(@RequestBody Beer beer) {
		System.out.println("************************");
		System.out.println(beer.getName());
		System.out.println(beer.getBrewery());
		System.out.println(beer.getStyle());
		System.out.println(beer.getBottleDate());
		System.out.println(beer.getVol());
		System.out.println(beer.getQuantity());
		System.out.println(beer.getId());
		System.out.println("************************");
		return beerService.addBeerToInventory(beer);
	};

	@RequestMapping(value = "removeBeer", method = RequestMethod.DELETE)
	public Beer removeBeerToInventory(@RequestBody Beer beer) {

		return beerService.removeBeerFromInventory(beer);
	}

	@RequestMapping(value = "updateBeer", method = RequestMethod.POST)
	public Beer updateBeerToInventory(@RequestBody Beer beer) {

		return beerService.updateBeerInInventory(beer);
	}

}
