//package com.glennon.inventory.utility;
//
//import com.glennon.inventory.model.Beer;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class InventoryUtility {
//
//    private static Map<Integer, Beer> beers = new HashMap<>();
//    private static String inventoryFile = "/Users/n0206644/personal_projects/inventory/json/inventory.json";
//
//    @SuppressWarnings("unchecked")
//    public void loadInventory() {
//
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader(inventoryFile)) {
//
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray beerList = (JSONArray) obj;
//
//            beerList.forEach(beer -> parseBeerInInventory((JSONObject) beer));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void parseBeerInInventory(JSONObject beer) {
//        JSONObject beerObject = (JSONObject) beer.get("beer");
//        Beer currentBeer = new Beer();
//
//        Long beerId = (Long) beerObject.get("id");
//        currentBeer.setId(beerId.intValue());
//
//        String beerName = (String) beerObject.get("name");
//        currentBeer.setName(beerName);
//
//        String beerStyle = (String) beerObject.get("style");
//        currentBeer.setStyle(beerStyle);
//
//        Long beerVolume = (Long) beerObject.get("vol");
//        currentBeer.setVol(beerVolume.intValue());
//
//        Long beerQuantity = (Long) beerObject.get("quantity");
//        currentBeer.setQuantity(beerQuantity.intValue());
//
//        Long bottleDate = (Long) beerObject.get("bottleDate");
//        currentBeer.setBottleDate(bottleDate.intValue());
//
//        String brewery = (String) beerObject.get("brewery");
//        currentBeer.setBrewery(brewery);
//
//        String location = (String) beerObject.get("location");
//        currentBeer.setLocation(location);
//
//        if (currentBeer.getId() > nextBeerId) {
//            nextBeerId = currentBeer.getId();
//        }
//
//        beers.put(currentBeer.getId(), currentBeer);
//
//    }
//
//    @SuppressWarnings("unchecked")
//    public void writeToInventory() {
//
//        JSONArray beerList = new JSONArray();
//
//        for (Beer currentBeer : beers.values()) {
//            JSONObject beerDetails = new JSONObject();
//            JSONObject beerObject = new JSONObject();
//
//            beerDetails.put("id", currentBeer.getId());
//            beerDetails.put("name", currentBeer.getName());
//            beerDetails.put("style", currentBeer.getStyle());
//            beerDetails.put("vol", currentBeer.getVol());
//            beerDetails.put("quantity", currentBeer.getQuantity());
//            beerDetails.put("bottleDate", currentBeer.getBottleDate());
//            beerDetails.put("brewery", currentBeer.getBrewery());
//            beerDetails.put("location", currentBeer.getLocation());
//
//            beerObject.put("beer", beerDetails);
//
//            beerList.add(beerObject);
//
//            try (FileWriter file = new FileWriter(inventoryFile)) {
//
//                file.write(beerList.toJSONString());
//                file.flush();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }
//}
