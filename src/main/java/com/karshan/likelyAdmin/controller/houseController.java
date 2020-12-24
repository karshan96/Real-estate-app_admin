/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karshan.likelyAdmin.controller;

import com.karshan.likelyAdmin.model.houses;
import com.karshan.likelyAdmin.service.houseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 *
 * @author Rasa Karshanguna
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class houseController {
    @Autowired
    houseService houseService;

    @GetMapping("/getHouseDetails")
    public houses getHouseDetails(@RequestParam String key ) throws InterruptedException, ExecutionException{
        return houseService.getHouseDetails(key);
    }
    
    @GetMapping("/getAllHouses")
    public List<houses> getAllHouses() throws InterruptedException, ExecutionException{
        return houseService.getAllHouses();
    }

    @PostMapping("/createHouse")
    public String createHouse(@RequestBody houses house ) throws InterruptedException, ExecutionException {
        return houseService.saveHouseDetails(house);
    }

    @PutMapping("/updateHouse")
    public String updateHouse(@RequestBody houses house ,String key) throws InterruptedException, ExecutionException {
        return houseService.updateHouseDetails(house, key);
    }

    @DeleteMapping("/deleteHouse")
    public String deleteHouse(@RequestParam String key) throws InterruptedException, ExecutionException{
        return houseService.deleteHouse(key);
    }

}
