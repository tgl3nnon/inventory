
package com.glennon.inventory.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.glennon.inventory.model.Beer;

@Repository
@Qualifier("fileData")
public class BeerDaoFileImpl implements BeerDao {

	private static final Logger logger = LoggerFactory.getLogger(BeerDaoFileImpl.class);

	private static Map<Integer, Beer> beers = new HashMap<>();
	private String inventoryFile = "D:/inventory/json/inventory.json";
	// private String inventoryFile = "C:/temp/inventory.json";
	int nextBeerId = 0;

	@Override
	public Collection<Beer> getAllBeers() {
		loadInventory();
		logger.info("==> Inventory loaded " + beers.size() + " <==");
		return beers.values();
	}

	@Override
	public Beer getBeer(Beer beer) {
		loadInventory();
		return beers.get(beer.getId());
	}

	@Override
	public Beer addBeerToInventory(Beer beer) {
		loadInventory();
		beer.setId(nextBeerId + 1);
		beers.put(beer.getId(), beer);
		writeToInventory();
		logger.info("==> Beer added to inventory " + beer.getName() + beer.getStyle() + beer.getId() + " <==");
		return beer;
	}

	@Override
	public Beer removeBeerFromInventory(Beer beer) {
		loadInventory();
		beers.remove(beer.getId());
		writeToInventory();
		logger.info("==> Beer removed from inventory " + beer.getName() + beer.getStyle() + beer.getId() + " <==");
		return beer;
	}

	@Override
	public Beer updateBeerInInventory(Beer beer) {
		beers.put(beer.getId(), beer);
		updateInventory(beer);
		loadInventory();
		logger.info("==> Beer updated in inventory " + beer.getName() + beer.getStyle() + beer.getId() + " <==");
		return beer;
	}

	@SuppressWarnings("unchecked") // suppresses warnings of beerDetails Object
	private void updateInventory(Beer beer) {

		boolean idSet = false;
		JSONArray beerList = new JSONArray();

		if (beer.getId() >= 0) {
			idSet = true;
		}

		for (Beer currentBeer : beers.values()) {
			JSONObject beerDetails = new JSONObject();
			JSONObject beerObject = new JSONObject();

			beerDetails.put("id", currentBeer.getId());
			beerDetails.put("name", currentBeer.getName());
			beerDetails.put("style", currentBeer.getStyle());
			beerDetails.put("vol", currentBeer.getVol());
			beerDetails.put("quantity", currentBeer.getQuantity());
			beerDetails.put("bottleDate", currentBeer.getBottleDate());
			beerDetails.put("brewery", currentBeer.getBrewery());
			beerDetails.put("location", currentBeer.getLocation());

			beerObject.put("beer", beerDetails);

			beerList.add(beerObject);

		}

		if (idSet == true) {

			JSONObject newBeerObject = new JSONObject();
			JSONObject newBeerDetails = new JSONObject();
			newBeerDetails.put("id", nextBeerId + 1);
			newBeerDetails.put("name", beer.getName());
			newBeerDetails.put("style", beer.getStyle());
			newBeerDetails.put("vol", beer.getVol());
			newBeerDetails.put("quantity", beer.getQuantity());
			newBeerDetails.put("bottleDate", beer.getBottleDate());
			newBeerDetails.put("brewery", beer.getBrewery());
			newBeerDetails.put("location", beer.getLocation());

			newBeerObject.put("beer", newBeerDetails);
			beerList.add(newBeerObject);

		}

		try (FileWriter file = new FileWriter(inventoryFile)) {

			file.write(beerList.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private void loadInventory() {

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(inventoryFile)) {

			Object obj = jsonParser.parse(reader);

			JSONArray beerList = (JSONArray) obj;

			beerList.forEach(beer -> parseBeerInInventory((JSONObject) beer));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void parseBeerInInventory(JSONObject beer) {
		JSONObject beerObject = (JSONObject) beer.get("beer");
		Beer currentBeer = new Beer();

		Long beerId = (Long) beerObject.get("id");
		currentBeer.setId(beerId.intValue());

		String beerName = (String) beerObject.get("name");
		currentBeer.setName(beerName);

		String beerStyle = (String) beerObject.get("style");
		currentBeer.setStyle(beerStyle);

		Long beerVolume = (Long) beerObject.get("vol");
		currentBeer.setVol(beerVolume.intValue());

		Long beerQuantity = (Long) beerObject.get("quantity");
		currentBeer.setQuantity(beerQuantity.intValue());

		Long bottleDate = (Long) beerObject.get("bottleDate");
		currentBeer.setBottleDate(bottleDate.intValue());

		String brewery = (String) beerObject.get("brewery");
		currentBeer.setBrewery(brewery);

		String location = (String) beerObject.get("location");
		currentBeer.setLocation(location);

		if (currentBeer.getId() > nextBeerId) {
			nextBeerId = currentBeer.getId();
		}

		beers.put(currentBeer.getId(), currentBeer);

	}

	@SuppressWarnings("unchecked")
	private void writeToInventory() {

		JSONArray beerList = new JSONArray();

		for (Beer currentBeer : beers.values()) {
			JSONObject beerDetails = new JSONObject();
			JSONObject beerObject = new JSONObject();

			beerDetails.put("id", currentBeer.getId());
			beerDetails.put("name", currentBeer.getName());
			beerDetails.put("style", currentBeer.getStyle());
			beerDetails.put("vol", currentBeer.getVol());
			beerDetails.put("quantity", currentBeer.getQuantity());
			beerDetails.put("bottleDate", currentBeer.getBottleDate());
			beerDetails.put("brewery", currentBeer.getBrewery());
			beerDetails.put("location", currentBeer.getLocation());

			beerObject.put("beer", beerDetails);

			beerList.add(beerObject);

			try (FileWriter file = new FileWriter(inventoryFile)) {

				file.write(beerList.toJSONString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
