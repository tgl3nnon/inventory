//
//package com.glennon.inventory.service;
//
//import com.glennon.inventory.dao.BeerDaoFileImpl;
//import com.glennon.inventory.model.Beer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//
//@Service
//public class BeerServiceImpl implements BeerService {
//
//    @Autowired
//    @Qualifier("fileData")
//    private BeerDaoFileImpl beerDao;
//
//    public Collection<Beer> getAllBeers() {
//
//        return beerDao.getAllBeers();
//    }
//
//    public Beer getBeer(Beer beer) {
//
//        return beerDao.getBeer(beer);
//    }
//
//    public Beer addBeerToInventory(Beer beer) {
//
//        return beerDao.addBeerToInventory(beer);
//    }
//
//    public Beer removeBeerFromInventory(Beer beer) {
//
//        return beerDao.removeBeerFromInventory(beer);
//    }
//
//    public Beer updateBeerInInventory(Beer beer) {
//
//        return beerDao.updateBeerInInventory(beer);
//    }
//
//}
