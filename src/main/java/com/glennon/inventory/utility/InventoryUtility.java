package com.glennon.inventory.utility;

import com.glennon.inventory.model.Beer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class InventoryUtility {

    private static Map<Integer, Beer> beers = new HashMap<>();
    private static String inventoryFile = "/Users/n0206644/personal_projects/inventory/json/inventory.json";

    @SuppressWarnings("unchecked")
    public void writeToInventory() {

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
